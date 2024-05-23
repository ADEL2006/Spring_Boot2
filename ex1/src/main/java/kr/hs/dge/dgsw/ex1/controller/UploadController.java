package kr.hs.dge.dgsw.ex1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UploadController {
    @Value("${project.upload.path}")
    private String uploadPath;

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("uploadFiles")List<MultipartFile> uploadFiles) {
        for (MultipartFile uploadFile: uploadFiles) {
            // image/jpg, image/jpeg
            if (!uploadFile.getContentType().startsWith("image")) {
                log.warn("This file is not image type");
                return;
            }


            String originalName = uploadFile.getOriginalFilename();
            // app.png
            // IE, Edge: C:\\upload\\app.png
            String fileName =  originalName.substring(
                    originalName.lastIndexOf("\\") + 1
            );
            log.info("fileName: {}", fileName);
        }
    }
}
