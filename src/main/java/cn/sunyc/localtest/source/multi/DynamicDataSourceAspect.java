package cn.sunyc.localtest.source.multi;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 注解解析的切面类，在运行mapper的方法之前查看注解中的数据源类型，确定好选择哪个数据源。
 *
 * @author SunYuChao
 * @date 2020/11/12 16:49
 * credits [SunYuChao,,]
 */
@Component
@Order(-1)// 保证该AOP在@Transactional之前执行
@Aspect
public class DynamicDataSourceAspect {

    @Before("execution(* cn.sunyc.localtest.service..*.*(..))")
    public void before(JoinPoint point) {
        try {
            ////    一、获取运行的类级别上的注解
            DataSourceSign annotationOfClass = point.getTarget().getClass().getAnnotation(DataSourceSign.class);

            ////    二、获取运行的方法级别的注解
            //          2.1 获取方法名称
            String methodName = point.getSignature().getName();
            //          2.2 获取方法参数类型列表
            Class[] parameterTypes = ((MethodSignature) point.getSignature()).getParameterTypes();
            //          2.3 获取被调用的方法的引用
            Method method = point.getTarget().getClass().getMethod(methodName, parameterTypes);
            //          2.4 获取该方法上面的注解。注：如果使用原生的 method.getAnnotation 不能获取被代理对象上面的注解。而下面spring官方提供的可以获取到。
            DataSourceSign methodAnnotation =  AnnotationUtils.findAnnotation(method, DataSourceSign.class);

            ////    三、按照优先级选择注解，优先级： 方法注解 > 类注解
            methodAnnotation = methodAnnotation == null ? annotationOfClass : methodAnnotation;

            ////    四、处理无任何注解情况：没有任何注解的时候，会选择 PRIMARY 类型数据源。
            DataSourceType dataSourceType = methodAnnotation != null ?
                    methodAnnotation.value() : DataSourceType.PRIMARY;

            ////    五、最终总会选择一个数据源，set到线程本地变量中。
            DataSourceContextHolder.setDataSource(dataSourceType.name());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @After("execution(* cn.sunyc.localtest.service..*.*(..))")
    public void after(JoinPoint point) {
        DataSourceContextHolder.clearDataSource();
    }
}
