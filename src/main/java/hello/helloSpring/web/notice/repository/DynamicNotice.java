package hello.helloSpring.web.notice.repository;

import hello.helloSpring.web.notice.model.Notice;

import java.util.List;

public interface DynamicNotice {
   List<Notice> findNoticeByTilte();
}
