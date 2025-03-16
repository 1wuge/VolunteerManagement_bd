package com.example.spring.demos.web;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.example.spring.Application;
import com.example.spring.Utils.TimeUtil;
import com.example.spring.service.NurseService;
import com.example.spring.service.TeacherService;
import com.example.spring.service.UserService;
import com.example.spring.service.VolunteerService;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import test.pojo.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/File")
public class FileController {

    @RequestMapping("/upload")//获取图片
    public String upload(MultipartFile file) {
        if(file.isEmpty())
        {
            return "图片上传失败";
        }
        String originalName=file.getOriginalFilename();//获取图片原来的名字
        int index=originalName.lastIndexOf(".");//获取最后一个.的位置
        String uuid= UUID.randomUUID().toString().replace("-","");
        String imgName="";
        if(index!=-1)
        {
            imgName=uuid+originalName.substring(index);
        }
        else{
            imgName=uuid;
        }

       String path=imgName;
        path="D:\\UGit\\VolunteerManagement_fd\\public\\img\\"+path;
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(path);

        return "./img/"+imgName;
    }

    @PostMapping("/exportInf")
    public void handleFileUpload(String imageLinks) {
        System.out.println(imageLinks);
    }
    @PostMapping("/importInf")
    public void importInf(@RequestParam("file") MultipartFile file,
                          @RequestParam("tName") String tName,
                          @RequestParam("avatar") String avatar) throws IOException {

        //使用inputStream流读取文件
        InputStream inputStream = file.getInputStream();
        //读取流中的数据
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        //将读取到的数据填充为List<Activities>
        List<VolunteerActivity> volunteerActivities = reader.readAll(VolunteerActivity.class);
        //将List导入数据库
        System.out.println(volunteerActivities);
        VolunteerService.importInf(volunteerActivities);
    }



}