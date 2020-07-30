package com.example.UploadFiles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherController {

    @GetMapping("/hello")
    String hello() {
        return "Hello";
    }
}
