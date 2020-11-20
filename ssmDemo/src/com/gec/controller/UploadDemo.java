package com.gec.controller;

import com.gec.exception.MyExecption;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Brice
 * @title: UploadDemo
 * @projectName springDemo
 * @description: TODO
 * @date 2020/11/1210:40
 */
@Controller
public class UploadDemo  {
    @RequestMapping("/test")
    public String test() throws MyExecption {
        try {
            double a=10/0;
        } catch (Exception e) {
            throw new MyExecption("除数不为0");
        }
        return "login";
    }

    @RequestMapping("/upload")
    public String upLoad(MultipartFile pic){
        System.out.println("pic.getName() = " + pic.getName());
        System.out.println("pic.getOriginalFilename() = " + pic.getOriginalFilename());
        if(!pic.isEmpty()){
            File file = new File("C:/Users/tonfaions/Desktop/JavaSE/upload");
            if(!file.exists()){
                file.mkdirs();
            }
            String fileName = pic.getOriginalFilename();
            String newFileName=UUID.randomUUID().toString().replace("-", "")+fileName.substring(fileName.lastIndexOf("."));
            try {

                pic.transferTo(new File("C:/Users/tonfaions/Desktop/JavaSE/upload/"+newFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    @RequestMapping(value = "/json",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json(){
        return "你好";
    }
}
