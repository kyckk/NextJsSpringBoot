package hello.helloSpring.web.notice.controller;

import hello.helloSpring.common.file.FileUtils;
import hello.helloSpring.web.file.model.FileResponse;
import hello.helloSpring.web.file.FileService;
import hello.helloSpring.web.notice.dto.NoticeResponse;
import hello.helloSpring.web.notice.model.Notice;
import hello.helloSpring.web.notice.repository.NoticeRepository;
import hello.helloSpring.web.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.*;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {
    private final NoticeService noticeService;
    private final FileUtils fileUtils;
    private final FileService fileService;
    @Autowired
    private NoticeRepository noticeRepository;

    @GetMapping("/board/list")
    public String list(Model model ,@PageableDefault(size = 10) Pageable pageable){

        Page<Notice> notice =noticeRepository.findAll(pageable);
       // List<HashMap<String,Object>> boards = noticeService.getList();
        //notice.getPageable().getPageNumber()=
        //pagesize 말고 10, 15,50 씩끊어서 읽을수잇는 변수가 필요함

        int pagesize =notice.getSize();
        System.out.println("pagesize="+pagesize);
        int currentPage =notice.getPageable().getPageNumber();
        int startPage = (currentPage-1)/pagesize*pagesize +1;
        int endPage=startPage+pagesize-1;
        if (endPage > notice.getTotalPages()){
            endPage=notice.getTotalPages();
        }
        model.addAttribute("startPage",startPage);
        model.addAttribute("endPage",endPage);
        model.addAttribute("boards",notice);
        return "board/list";
    }

    @GetMapping("/board/form")
    public String form(Model model, @RequestParam(required = false) String noticeId ){
        if(noticeId == null){
            model.addAttribute("board",new Notice());
        }else{

            Notice board = noticeRepository.findById(noticeId).orElse(null);
            System.out.println(board);
            model.addAttribute("board",board);
        }
        return "board/form";
    }

    //리액트 api
    @GetMapping("/board/getForm")
    public String getform(Model model, @RequestParam(required = false) String noticeId ){
        if(noticeId == null){
            model.addAttribute("board",new Notice());
        }else{

            Notice board = noticeRepository.findById(noticeId).orElse(null);
            System.out.println(board);
            model.addAttribute("board",board);
        }
        return "board/form";
    }

    @PostMapping("/board/reactForm")
    @ResponseBody
    public String greetingSubmit(@ModelAttribute Notice notice  ){

        if(notice.getNoticeId() == null ||notice.getNoticeId().equals("") ) {
            System.out.println("----------------");
            String max = String.valueOf(noticeService.maxCnt() + 1);
            notice.setNoticeId(max);
        }

        noticeRepository.save(notice);
        return "sucess";
    }

    @PostMapping("/board/test")
    @ResponseBody
    public Map<String, Object> test(Model model,@RequestParam String searchNum , @RequestParam String title, @PageableDefault(size = 10) Pageable pageable){
        if(searchNum == null || searchNum == ""){
            searchNum = "1";
        }

        System.out.println("gkgkgkgkgkgkg");
        Page<NoticeResponse> noticePageable= noticeService.noticePageable(title,searchNum,pageable);
        System.out.println("noticePageable="+ noticePageable.getTotalPages());
        int pagesize =noticePageable.getSize();

        System.out.println("pagesize="+pagesize);
        int currentPage =noticePageable.getPageable().getPageNumber();
        int startPage = (currentPage-1)/pagesize*pagesize +1;
        int endPage=startPage+pagesize-1;
        if (endPage > noticePageable.getTotalPages()){
            endPage=noticePageable.getTotalPages();
        }

        Map<String,Object> listMap= new HashMap<>();
        noticeService.getSearchList();
        listMap.put("startPage",startPage);
        listMap.put("endPage",endPage);
        listMap.put("searchNum",searchNum);
        listMap.put("pagesize",pagesize);
        listMap.put("boards",noticePageable);
        return listMap;

    }

    @GetMapping("/boardtest2")
    public String findAllProductList2(Model model,Notice notice){
        List<Notice> list =new ArrayList<>();
        notice.setNoticeId("18");
        notice.setTitle("테스트제목18");
        notice.setContent("테스트내용");
        notice.setInsertDt(null);
        notice.setUpdateDt(null);
        list.add(notice);
        System.out.println(list);
        model.addAttribute("productList", list);
        return "board/list::#noticeList";
    }

    @PostMapping("/board/image")
    @ResponseBody
    public String fileUpload(@RequestParam("uploadFile")List<MultipartFile> uploadFile, HttpServletRequest req){
        System.out.println("uploadFile="+uploadFile.toArray().length);
        System.out.println("req="+req);
        List<FileResponse> files =fileUtils.uploadFiles(uploadFile);
        fileService.saveFiles(files);
        return "sucees";
    }

    @PostMapping("/pages")
    @ResponseBody
    public String getNoticeDetail(@RequestParam String idx ){
        System.out.println("{idx}="+idx);
        return null;
    }
}
