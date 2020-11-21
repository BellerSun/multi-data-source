package cn.sunyc.localtest;

import cn.sunyc.localtest.service.RecordService;
import cn.sunyc.localtest.service.TransService;
import cn.sunyc.localtest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class LocalTestApplicationTests {
    @Resource
    UserService userService;
    @Resource
    TransService transService;
    @Resource
    RecordService recordService;

    @Test
    void contextLoads() {
        // 分别从三个不同的从数据源读取消息。mysql、mysql、polarDb
        /*final List<User> users = userService.queryAll();
        final List<Trans> trans = transService.queryAll();
        final List<Record> records = recordService.queryAll();

        System.out.println(JSON.toJSONString(users));
        System.out.println(JSON.toJSONString(trans));
        System.out.println(JSON.toJSONString(records));*/
    }

}
