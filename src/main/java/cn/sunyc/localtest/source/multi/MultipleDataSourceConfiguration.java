package cn.sunyc.localtest.source.multi;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * 数据源的配置类。在本配置类中，会注入多种不同的数据源bean到{@link DynamicDataSource}中。<br/>
 *
 * @author SunYuChao
 * @date 2020/11/12 16:11
 * credits [SunYuChao,,]
 */
@Configuration
public class MultipleDataSourceConfiguration {
    //@Primary注解在哪个ds，默认使用那个ds

    @Bean(name = "dataSourcePrimary")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "dataSourceUser")
    @ConfigurationProperties(prefix = "spring.datasource.user")
    public DataSource userDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "dataSourceRecord")
    @ConfigurationProperties(prefix = "spring.datasource.record")
    public DataSource recordDataSource() {
        return new DruidDataSource();
    }

    /**
     * 动态数据源bean。默认的是 primaryDataSource。
     *
     * @return 其他的特殊指定就是 {@link DataSourceType}类型对应的数据源。
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //配置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(primaryDataSource());

        //配置多数据源
        HashMap<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DataSourceType.PRIMARY.name(), primaryDataSource());
        dataSourceMap.put(DataSourceType.USER.name(), userDataSource());
        dataSourceMap.put(DataSourceType.RECORD.name(), recordDataSource());
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    /**
     * 将配置好的动态数据源注入到事务处理器中。
     * 配置@Transactional注解事务
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
