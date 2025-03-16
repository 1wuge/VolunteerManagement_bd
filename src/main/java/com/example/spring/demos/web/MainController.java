package com.example.spring.demos.web;

import com.example.spring.Utils.TimeUtil;
import com.example.spring.service.NurseService;
import com.example.spring.service.TeacherService;
import com.example.spring.service.UserService;
import com.example.spring.service.VolunteerService;
import com.example.spring.vo.ResultVo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import test.pojo.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Student")
public class MainController {
    @PostMapping("/activities")//获取活动数量
    public ResultVo getNum(String name,boolean isSearch)
    {
        return VolunteerService.getNum(name,isSearch);
    }
    @PostMapping("/apply")//写入评论
    public int List(String account,String activityName,String tName)
    {
       return VolunteerService.apply(account,activityName,tName);
    }
    @PostMapping("/getAccount")//获取账号信息
    public ResultVo getAccount(String account)
    {
        return UserService.getAccount(account);
    }
    @PostMapping("/paginate")//获取全部活动的分页信息
    public ResultVo paginate(int page,int size,String name,boolean isSearch)
    {

        return VolunteerService.paginate(page,size,name,isSearch);
    }

    @PostMapping("/getStuActi")
    public List<VolunteerActivity> GetStuActi(String account)
    {
        return VolunteerService.selectByAccount(account);
    }
    @PostMapping("/deleteStuActi")
    public int DeleteStuActi(String account,String activityName,String tName)
    {
        return VolunteerService.deleteStuActi(account,activityName,tName);
    }
    @PostMapping("/query")
    public ResultVo Query(String activityName,String tName)
    {
        return VolunteerService.selectByNames(activityName,tName);
    }
    @PostMapping("/updatePassword")
    public ResultVo updatePassword(Account form, String newPassword)
    {
        return UserService.updatePassword(form,newPassword);
    }
    @PostMapping("/saveInf")
    public ResultVo saveInf(Account form)
    {

        return UserService.saveInf(form);
    }
    @PostMapping("/getHasDoneNum")//获取该学生完成的活动的数量
    public ResultVo finish(String account,String name,boolean isSearch)
    {

        return VolunteerService.searchD(name,account,isSearch);
    }

    @PostMapping("/getHasGotNum")//根据活动名或教师名搜素该学生参加的活动
    public ResultVo searchG(String name,String account,boolean isSearch)
    {
        return VolunteerService.searchG(name,account,isSearch);
    }
    @PostMapping("/finishPaginate")//根据活动名或教师名搜素该学生参加并已经结束的活动
    public ResultVo finishPaginate(String account,int page,int size,String name,boolean isSearch)
    {

        return VolunteerService.hasDonePaginate(account,page,size,name,isSearch);
    }
    @PostMapping("/hasGotPaginate")//根据活动名或教师名搜素该学生参加并已经结束的活动
    public ResultVo hasGotPaginate(String account,int page,int size,String name,boolean isSearch)
    {

        return VolunteerService.hasGotPaginate(account,page,size,name,isSearch);
    }
}



