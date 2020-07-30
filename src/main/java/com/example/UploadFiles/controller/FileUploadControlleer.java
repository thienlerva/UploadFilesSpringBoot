package com.example.UploadFiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadControlleer {

    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

    @RequestMapping("/")
    public String uploadPage(Model model) {
        System.out.println(uploadDirectory);
        return "uploadview";
    }

    @RequestMapping("/upload")
    public String upload(Model model, @RequestParam("files") MultipartFile[] files) {
        StringBuilder fileName = new StringBuilder();

        for (MultipartFile file : files) {
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            System.out.println("original file name: " + file.getOriginalFilename());
            System.out.println("fileNameand path: " + fileNameAndPath);
            fileName.append(file.getOriginalFilename() + " ");

            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("msg", "Successfully uploaded files " + fileName.toString());
        System.out.println(model);
        return "uploadstatusview";
    }


}
