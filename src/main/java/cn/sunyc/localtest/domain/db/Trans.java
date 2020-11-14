package cn.sunyc.localtest.domain.db;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @author SunYuChao
 * @date 2020/11/12 17:05
 * credits [SunYuChao,,]
 */
@Data
@TableName("t_trans")
public class Trans {
    private Integer id;
    private String transId;
    private String desc;
}
