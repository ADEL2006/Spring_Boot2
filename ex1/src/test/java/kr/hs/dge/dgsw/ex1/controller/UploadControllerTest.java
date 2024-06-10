package kr.hs.dge.dgsw.ex1.controller;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class UploadControllerTest {

    @Test
    void test() {
        File file = new File ("2024%2F06%2F05%2F110925e6-feb9-402c-8a70-c95573678440_nomuhyun.png");
        System.out.println(file.exists());
    }
}