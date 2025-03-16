package com.example.spring.demos.web;

import com.example.spring.service.TeacherService;
import com.example.spring.service.UserService;
import com.example.spring.service.VolunteerService;
import com.example.spring.vo.ResultVo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.pojo.Account;
import test.pojo.Teacher;
import test.pojo.VolunteerActivity;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Manager")
public class ManagerController {
    @PostMapping("/getStu")//获取学生信息
    public List<Account> GetStu()
    {
        return UserService.selectAll();
    }
    @PostMapping("/deleteStu")//删除学生信息
    public void List(Account stu)
    {
       UserService.deleteByAccount(stu.getAccount());
       VolunteerService.deleteByStuNum(stu.getAccount());
    }
    @PostMapping("/resetStu")//给学生重置密码
    public void ResetStu(Account stu)
    {
        UserService.resetPassword(stu);
    }
    @PostMapping("/applyStu")//添加学生账户
    public ResultVo ApplyStu(Account stu)
    {
       return UserService.register(stu.getAccount(),stu.getUsername(),stu.getPassword());
    }

    @PostMapping("/getTeacher")//获取教师信息
    public List<Teacher> GetTeacher()
    {
        return TeacherService.selectAll();
    }
    @PostMapping("/resetTeacherPass")//给教师重置密码
    public void ResetTeacher(Teacher stu)
    {
        TeacherService.resetPassword(stu);
    }

    @PostMapping("/deleteTeacher")//删除教师信息
    public void deleteT(Teacher teac)
    {
        TeacherService.deleteByTName(teac.getTName());
        VolunteerService.deleteByTName(teac.getTName());
    }
    @PostMapping("/changeTeacherName")//修改教师姓名
    public ResultVo changeTName(Teacher teac,String newName)
    {
        return TeacherService.changeTName(teac,newName);
    }
    @PostMapping("/applyTeacher")//添加教师
    public ResultVo applyTeacher(Teacher teac)
    {
        return TeacherService.applyTeacher(teac);
    }

}



