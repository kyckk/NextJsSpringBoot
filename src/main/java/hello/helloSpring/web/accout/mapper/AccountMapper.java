package hello.helloSpring.web.accout.mapper;

import hello.helloSpring.web.accout.dto.AccountDTO;
import hello.helloSpring.web.accout.frame.FrameMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AccountMapper extends FrameMapper<String, AccountDTO> {
}
