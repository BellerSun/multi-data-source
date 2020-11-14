package cn.sunyc.localtest.service;

/**
 * @author SunYuChao
 * @date 2020/11/12 16:51
 * credits [SunYuChao,,]
 */

import cn.sunyc.localtest.domain.db.Trans;
import cn.sunyc.localtest.mapper.TransMapper;
import cn.sunyc.localtest.source.multi.DataSourceSign;
import cn.sunyc.localtest.source.multi.DataSourceType;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *当方法上有我们定义的 DataSourceSign 注解时，根据其value动态切换数据源:
 *只需在需要切换数据源的方法上添加@DataSourceSign注解即可，若使用主数据源，不用添加注解。
 */
@Service
public class TransServiceImpl extends ServiceImpl<TransMapper, Trans>
        implements TransService {

    @Autowired
    private TransMapper transMapper;

    @Override
    @DataSourceSign(DataSourceType.PRIMARY)
    public List<Trans> queryAll(){
        return transMapper.selectList(null);
    }

}
