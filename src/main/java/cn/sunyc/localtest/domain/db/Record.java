package cn.sunyc.localtest.domain.db;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @author SunYuChao
 * @date 2020/11/12 17:05
 * credits [SunYuChao,,]
 */
@Data
@TableName("t_record")
public class Record {
    private Integer id;
    private String desc;
}
