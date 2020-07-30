package com.example.UploadFiles;

import com.example.UploadFiles.controller.FileUploadControlleer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
public class UploadFilesApplication {

	public static void main(String[] args) {
		new File(FileUploadControlleer.uploadDirectory).mkdir();
		SpringApplication.run(UploadFilesApplication.class, args);
	}

}
