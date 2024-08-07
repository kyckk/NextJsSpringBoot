package hello.helloSpring.web.notice.repository;

import hello.helloSpring.web.notice.model.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice,String> ,DynamicNotice ,PageableNotice{
    Page<Notice> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);


}
