package hello.helloSpring.web.file;

import hello.helloSpring.web.file.model.FileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileMapper fileMapper ;
  @Transactional
    public void saveFiles(List<FileResponse> files){
      fileMapper.saveAll(files);
  }

}
