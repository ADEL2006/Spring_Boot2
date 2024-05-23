package kr.hs.dge.dgsw.ex1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

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

            String folderPath = makeFolder();
            log.info("folderPath: {}", folderPath);

            String uuid = UUID.randomUUID().toString();

            String saveName = uploadPath + File.separator + folderPath + File.separator + uuid + "=" + fileName;
            log.info("saveName: {}", saveName);
            Path path = Paths.get(saveName);

            try {
                uploadFile.transferTo(path);
            } catch (IOException e) {

            }
        }
    }

    private String makeFolder() {
        // str = "2024/05/23'
        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        // window: \, mac: /
        String folderPath = str.replace("//", File.separator);
        File uploadPathFolder = new File(uploadPath, folderPath);
        if(!uploadPathFolder.exists()) {
            uploadPathFolder.mkdirs();
        }
        return folderPath;
    }
}
