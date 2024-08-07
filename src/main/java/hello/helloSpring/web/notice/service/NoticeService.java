package hello.helloSpring.web.notice.service;

import hello.helloSpring.web.notice.dto.NoticeResponse;
import hello.helloSpring.web.notice.mapper.NoticeMapper;
import hello.helloSpring.web.notice.model.Notice;
import hello.helloSpring.web.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper noticeMapper;
    private final NoticeRepository noticeRepository;

    public  List<HashMap<String,Object>>getList(){
        return noticeMapper.getList();

    }

    public int maxCnt() {
        return noticeMapper.maxCnt();
    }

    public List<Notice> getSearchList() {
        System.out.println(noticeMapper.getSearchList());
        noticeMapper.getSearchList();
        return   noticeMapper.getSearchList();
    }

    public List <Notice> findNoticeByTilte() {
        return noticeRepository.findNoticeByTilte();
    }

    public Page<NoticeResponse> noticePageable(String title, String searchNum, Pageable pageable) {
        return  noticeRepository.searchPage( title,searchNum,pageable);
    }
}
