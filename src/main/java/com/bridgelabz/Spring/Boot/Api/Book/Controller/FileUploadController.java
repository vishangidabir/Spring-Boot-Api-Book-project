package com.bridgelabz.Spring.Boot.Api.Book.Controller;

import com.bridgelabz.Spring.Boot.Api.Book.Helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
    @Autowired
    private FileUploadHelper fileUploadHelper;
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getSize());
//        System.out.println(file.getContentType());
//        System.out.println(file.getName());
        try {
            //validation------------------------------->
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            }
            if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG type content are allowed");
            }
            //file uploadcode-------------------------->
            boolean f = fileUploadHelper.uploadfile(file);
            if(f){
                return ResponseEntity.ok("File is successfully uploaded !");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        //file upload code


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some thing went wrong !Try again   ");
    }
}
