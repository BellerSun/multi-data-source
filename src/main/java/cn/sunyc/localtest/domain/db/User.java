package cn.sunyc.localtest.domain.db;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @author SunYuChao
 * @date 2020/11/12 17:04
 * credits [SunYuChao,,]
 */
@Data
@TableName("t_user")
public class User {
    private Integer id;
    private String userId;
    private String userName;
}
