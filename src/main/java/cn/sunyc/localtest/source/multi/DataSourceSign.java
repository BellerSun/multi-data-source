package cn.sunyc.localtest.source.multi;

import java.lang.annotation.*;

/**
 * 数据源标志注解，默认是 PRIMARY
 *
 * @author SunYuChao
 * @date 2020/11/12 16:43
 * credits [SunYuChao,,]
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface DataSourceSign {
    DataSourceType value() default DataSourceType.PRIMARY;
}