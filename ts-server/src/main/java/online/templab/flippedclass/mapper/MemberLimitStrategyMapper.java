package online.templab.flippedclass.mapper;

import online.templab.flippedclass.entity.MemberLimitStrategy;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
/**
 * @author chenr
 */
@Component
public interface MemberLimitStrategyMapper extends Mapper<MemberLimitStrategy> {
}