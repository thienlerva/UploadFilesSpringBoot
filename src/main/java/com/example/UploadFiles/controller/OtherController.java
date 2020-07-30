package com.example.UploadFiles.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/other")
public class OtherController {

    final String uploadDirectory = System.getProperty("user.dir") + "/uploads";

    @GetMapping("/hello")
    String hello() {
        return "Hello";
    }

    @GetMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("file")MultipartFile file) {
        try {
            File convertFile = new File(uploadDirectory + "/" + file.getOriginalFilename());
            System.out.println("filename: " + file.getOriginalFilename());
            System.out.println(convertFile.getAbsolutePath());
            //convertFile.createNewFile();
            FileOutputStream out = new FileOutputStream(convertFile);
            out.write(file.getBytes());
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        } catch (IOException io) {
            System.out.println("IO Exception");
        }
        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);

    }
}
