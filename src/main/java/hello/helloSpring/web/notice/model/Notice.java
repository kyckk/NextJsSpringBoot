package hello.helloSpring.web.notice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Data
@Table(name="notice")// 테이블이름
public class Notice {
    @Id
    private String noticeId;
    private String title;
    private String content;
    private LocalDateTime insertDt;
    private LocalDateTime updateDt;
}
