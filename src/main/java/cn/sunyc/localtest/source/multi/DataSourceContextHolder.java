package cn.sunyc.localtest.source.multi;

import lombok.extern.slf4j.Slf4j;

/**
 * 数据源的切换上下文存储器。<br/>
 * 切面处理器{@link DynamicDataSourceAspect}会根据class或者method上的注解，在执行被调用方法前后设置和清除数据源。
 *  <ul>
 *      <li>执行方法之前：&nbsp;&nbsp; 调用本类的{@link DataSourceContextHolder#setDataSource(String)}方法确定好当前线程该使用何种类型的数据源。</li>
 *      <li>执行方法之后：&nbsp;&nbsp; 调用本类的{@link DataSourceContextHolder#clearDataSource()}方法清除现成数据源，避免造成数据源混乱。</li>
 *  </ul>
 * 所以一切没有明确设置数据源的地方统统不会受到影响，皆为Primary类型的数据源。
 *
 * @author SunYuChao
 * @date 2020/11/12 16:42
 * credits [SunYuChao,,]
 */
@Slf4j
public class DataSourceContextHolder {
    private static final String DEFAULT_DATASOURCE = "PRIMARY_DATASOURCE";
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();
    public static void setDataSource(String dbType){
        log.debug("切换到["+dbType+"]数据源");
        CONTEXT_HOLDER.set(dbType);
    }

    public static String getDataSource(){
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSource(){
        CONTEXT_HOLDER.remove();
    }
}
