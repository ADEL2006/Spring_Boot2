package kr.hs.dge.dgsw.ex1.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UploadController {
    @Value("${project.upload.path}")
    private String uploadPath;
}
