package hello.helloSpring.web.accout.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AccountDTO {

    private String userId;
    private String userPwd;
    private String userName;
    private String userTel;
    private String userEmail;
}