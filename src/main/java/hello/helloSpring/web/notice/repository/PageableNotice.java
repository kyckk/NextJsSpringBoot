package hello.helloSpring.web.notice.repository;

import hello.helloSpring.web.notice.dto.NoticeResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PageableNotice {

    Page<NoticeResponse> searchPage(String title, String searchNum, Pageable pageable);


}
