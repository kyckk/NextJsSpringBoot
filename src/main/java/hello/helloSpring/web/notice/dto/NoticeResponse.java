package hello.helloSpring.web.notice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeResponse {
    private String noticeId;
    private String title;
    private String content;
    private LocalDateTime insertDt;
    private LocalDateTime updateDt;

//    @Builder
//    private NoticeResponse(String noticeId,String title,String content,LocalDateTime insertDt,LocalDateTime updateDt){
//        this.noticeId=noticeId;
//        this.title=title;
//        this.content=content;
//        this.insertDt=insertDt;
//        this.updateDt=updateDt;
//
//    }


}
