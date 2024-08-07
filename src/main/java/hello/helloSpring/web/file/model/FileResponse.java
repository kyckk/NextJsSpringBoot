package hello.helloSpring.web.file.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
public class FileResponse {

    private int id;                // 파일 번호 (PK)
    private String noticeId;            // 게시글 번호 (FK)
    private String originalName;    // 원본 파일명
    private String saveName;        // 저장 파일명
    private int fileSize;              // 파일 크기

    @Builder
    public FileResponse(String originalName, String saveName, int fileSize) {
        this.originalName = originalName;
        this.saveName = saveName;
        this.fileSize = fileSize;
    }

    public void setPostId(String noticeId) {
        this.noticeId = noticeId;
    }

}
