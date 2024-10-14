package com.bridgelabz.Spring.Boot.Api.Book.Helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR="D:\\Spring Boot Project\\Spring-Boot-Api-Book\\src\\" +
            "main\\resources\\static\\image";

    public Boolean uploadfile(MultipartFile multipartFile){
        boolean f = false;
        try{
            //option 1:
//            InputStream inputStream = multipartFile.getInputStream();
//            byte data[] = new byte[inputStream.available()];
//            inputStream.read(data);
//
//            //Write
//            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename());
//            fileOutputStream.write(data);
//            fileOutputStream.flush();
//            fileOutputStream.close();
//            f=true;

            //Option 2:
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

        }catch(Exception e){
            e.printStackTrace();
        }
        return f;

    }
}
