package cn.sunyc.localtest.mapper;

import cn.sunyc.localtest.domain.db.Record;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author SunYuChao
 * @date 2020/11/12 16:52
 * credits [SunYuChao,,]
 */
@Mapper
@Component
public interface RecordMapper extends BaseMapper<Record> {
}
