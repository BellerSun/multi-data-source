package cn.sunyc.localtest.source.multi;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源的路由器（获取器）。<br/>
 * 实际是调用的{@link DataSourceContextHolder} 获取到的当前线程应该使用哪种数据源。
 *
 * @author SunYuChao
 * @date 2020/11/12 16:42
 * credits [SunYuChao,,]
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}