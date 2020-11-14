package cn.sunyc.localtest.service;

import cn.sunyc.localtest.domain.db.User;
import cn.sunyc.localtest.source.multi.DataSourceSign;
import cn.sunyc.localtest.source.multi.DataSourceType;

import java.util.List;

/**
 * @author SunYuChao
 * @date 2020/11/12 16:53
 * credits [SunYuChao,,]
 */
public interface UserService {

    @DataSourceSign(DataSourceType.USER)
    List<User> queryAll();
}
