package cn.sunyc.localtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author 孙玉朝
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class LocalTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocalTestApplication.class, args);
    }

}
