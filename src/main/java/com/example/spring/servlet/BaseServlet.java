package com.example.spring.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求路径
        StringBuffer requestURL = req.getRequestURL();
        String methodName = requestURL.substring(requestURL.lastIndexOf("/") + 1);
        //获取子类信息
        Class clz=this.getClass();

        //获取子类的方法并运行
        try {
            Method method = clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
    public void writeJson(HttpServletResponse resp,Object object) {
        resp.setContentType("text/html;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            String s = objectMapper.writeValueAsString(object);
            resp.getWriter().print(s);
        }catch(Exception X)
        {
            X.printStackTrace();
        }


    }


}
