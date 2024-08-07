package hello.helloSpring.common.file;

import hello.helloSpring.web.file.model.FileResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Component
public class FileUtils {
   public List<FileResponse> uploadFiles(List<MultipartFile> multipartFiles){
       List<FileResponse> files =new ArrayList<>();
       for (MultipartFile fileEl : multipartFiles){
           if(fileEl.isEmpty()){
               continue;
           }
           String filename = fileEl.getOriginalFilename(); // 기본 파일명
           String uuid = UUID.randomUUID().toString();
           String filepath ="/Users/klim/upload" + "/" +uuid+filename ;//다시


           File file = new File(filepath);

           try {
               BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
               bos.write(fileEl.getBytes());
               bos.close();

           } catch (Exception e) {
               return null;
           }
           files.add(FileResponse.builder().originalName(filename).saveName(uuid+filename).fileSize((int) multipartFiles.size()).build());
       }
       return files;
   }
}
