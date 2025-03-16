package com.example.spring.servlet;


import javax.servlet.annotation.WebServlet;

@WebServlet("/member/*")
public class MainServlet extends BaseServlet{
//    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //获取session对象
//        HttpSession session=req.getSession();
//        req.setCharacterEncoding("UTF-8");//避免乱码
//        resp.setContentType("text/html;charset=utf-8");//避免乱码
//        //resp.setContentType("application/json");//设置为json，好传数据给前端
//        PrintWriter writer = resp.getWriter();//可以在页面直接写东西
//        System.out.println("nb");
//        String num=req.getParameter("num");
//        String password=req.getParameter("password");
//        Account judge= UserService.selectByAccount(num,password);//调用service查询
//        Result result=new Result();
//        if(judge!=null){
//            result.setFlag(true);
//            result.setMsg("登录成功");
//
//            session.setAttribute("account",judge);//登录成功，就把用户信息放进session里,进入其他页面可以通过他来判断此用户是谁以及是否有用户登录
//
//        }
//        else{
//            result.setFlag(false);
//            result.setMsg("登录失败");
//        }
//        writeJson(resp,result);
//    }
//    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session=req.getSession();//有则获取，无则创建
//        req.setCharacterEncoding("UTF-8");//避免乱码
//        resp.setContentType("text/html;charset=utf-8");//避免乱码
//        PrintWriter writer = resp.getWriter();//可以在页面直接写东西
//
//        session.invalidate();//销毁session
//
//        Result result=new Result();
//        result.setFlag(true);//通过flag来判断是否退出
//        writeJson(resp,result);
//    }
//
//    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");//避免乱码
//        resp.setContentType("text/html;charset=utf-8");//避免乱码
//        PrintWriter writer = resp.getWriter();//可以在页面直接写东西
//        String userName=req.getParameter("userName");
//        String num=req.getParameter("num");
//        String name=req.getParameter("name");
//        String password=req.getParameter("password");
//        String ensure=req.getParameter("ensure");
//        String email=req.getParameter("email");
//        String phoneNumber=req.getParameter("phoneNumber");
//
//        Account account = new Account(name, num, password, userName, phoneNumber, email);//新建account对象，方便下一步的注册
//        boolean judge= UserService.register(account);//没有重复学号则注册成功返回true,否则返回false
//        Result result=new Result();
//        if(judge){
//            //注册成功
//            result.setFlag(true);
//            result.setMsg("注册成功");
//
//        }else{
//            result.setFlag(false);
//            result.setMsg("注册失败");
//        }
//        writeJson(resp,result);
//    }
//
//    //用来查找当前用户
//    public void findUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session=req.getSession();//有则获取，无则创建
//        req.setCharacterEncoding("UTF-8");//避免乱码
//        resp.setContentType("text/html;charset=utf-8");//避免乱码
//        PrintWriter writer = resp.getWriter();//可以在页面直接写东西
//
//        Account account= (Account) session.getAttribute("account");
//
//
//        Result result=new Result();
//        result.setFlag(true);
//        result.setData(account);
//
//        writeJson(resp,result);
//    }


}
