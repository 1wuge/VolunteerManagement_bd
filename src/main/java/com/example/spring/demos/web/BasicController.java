/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spring.demos.web;

import com.example.spring.Utils.TimeUtil;
import com.example.spring.service.NurseService;
import com.example.spring.service.TeacherService;
import com.example.spring.service.UserService;
import com.example.spring.vo.ResultVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import test.pojo.*;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class BasicController {

    @PostMapping("/login")//登录操作
    public Account login(@RequestParam("account")String account,@RequestParam("password")String password)
    {
            System.out.println("成功");
            System.out.println(UserService.selectByAccount(account,password));
            return UserService.selectByAccount(account,password);
    }
    @PostMapping("/loginT")//登录操作
    public Teacher loginT(@RequestParam("account")String account,@RequestParam("password")String password)
    {
            System.out.println(TeacherService.selectByAccount(account,password));
            return TeacherService.selectByAccount(account,password);

    }

    @GetMapping("/register")//注册操作
    public ResultVo register(@RequestParam("account")String account, @RequestParam("username")String username, @RequestParam("password")String password)
    {
        System.out.println("注册");
        System.out.println(account+" "+username);
        return UserService.register(account,username,password);
    }











    private String sendToPythonAndGetResult(String imagePath,String model) {
        // 使用 RestTemplate 调用 PyCharm 服务
        RestTemplate restTemplate = new RestTemplate();

        String pythonServiceUrl = "http://localhost:5000/process"; // PyCharm 服务地址

        Map<String, String> request = new HashMap<>();
        request.put("image_path", imagePath);
        request.put("model", model);
        ResponseEntity<Map> response = restTemplate.postForEntity(pythonServiceUrl, request, Map.class);
        return (String) Objects.requireNonNull(response.getBody()).get("result");
    }
    @PostMapping("/load")//获取图片
    public String Upload(@RequestParam("image")MultipartFile file,String model)
    {

        if(file.isEmpty())
        {
            return "失败";
        }
        try {
            File tempFile = File.createTempFile("uploaded-", file.getOriginalFilename());
            file.transferTo(tempFile);
            System.out.println(tempFile.getAbsolutePath());
            String result = sendToPythonAndGetResult(tempFile.getAbsolutePath(),model);
            return result;
        } catch (IOException e) {
            return "失败";
        }

    }






}
