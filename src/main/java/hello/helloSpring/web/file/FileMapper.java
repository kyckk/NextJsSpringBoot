package hello.helloSpring.web.file;

import hello.helloSpring.web.file.model.FileResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    void saveAll(List<FileResponse> files);
}
