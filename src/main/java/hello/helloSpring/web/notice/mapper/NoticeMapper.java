package hello.helloSpring.web.notice.mapper;

import hello.helloSpring.web.notice.model.Notice;
import org.apache.ibatis.annotations.Mapper;


import java.util.HashMap;
import java.util.List;

@Mapper
public interface NoticeMapper  {
    List<HashMap<String,Object>> getList();

    int maxCnt();

    List<Notice> getSearchList();
}
