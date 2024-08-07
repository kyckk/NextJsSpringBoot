package hello.helloSpring.web.accout.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import hello.helloSpring.web.accout.dto.AccountDTO;
import hello.helloSpring.web.accout.mapper.AccountMapper;
//import hello.helloSpring.web.accout.service.AccountService;
import hello.helloSpring.web.notice.model.Notice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Negative;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AccountController {

   // private final AccountService accountService;

//    @Autowired
//    private AccountMapper accountMapper;

    @GetMapping("/account")
    public String accountList(){
//        String k = "";
//        try {
//                   List<Notice> listMap =accountMapper.selectAll();
//                    System.out.println(listMap);
//            System.out.println(listMap);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

        return "조회성공";
    }
}
