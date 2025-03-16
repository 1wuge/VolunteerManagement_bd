package com.example.spring.demos.web;

import com.example.spring.service.TeacherService;
import com.example.spring.service.VolunteerService;
import com.example.spring.vo.ResultVo;
import org.springframework.web.bind.annotation.*;
import test.pojo.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Teacher")
public class TeacherMainController {

    /**
     * 添加活动
     * @param form
     * @return
     */
    @PostMapping("/applyTeacherActi")//
    public int List(VolunteerActivity form)
    {
        System.out.println(form);
       return VolunteerService.applyTeacherActi(form);
    }

    /**
     * 根据教师姓名获取活动项目的数量
     * @param tName
     * @return
     */
    @PostMapping("/getTeacherActi")
    public ResultVo getNumByTName(String tName)
    {
        return VolunteerService.getActNumByTName(tName);
    }

    /**
     * 删除一条志愿者活动，根据活动名和教师名
     * @param form
     * @return
     */
    @PostMapping("/deleteTeacherActi")//
    public int DeleteTActi(VolunteerActivity form)
    {
        return VolunteerService.deleteTeacherActi(form.getActivityName(),form.getTName());
    }

    /**
     * 批量删除教师的活动
     * @param tName
     * @param activityNames
     * @return
     */
    @PostMapping("/delBatch")
    public ResultVo delBatch(@RequestParam String tName,
                             String activityNames)
    {
        String[] names=activityNames.split(",");
        return VolunteerService.delBatch(tName,names);
    }
    @PostMapping("/saveInf")
    public ResultVo saveInf(Teacher form)
    {
        System.out.println(form);
        return TeacherService.saveInf(form);
    }

    @PostMapping("/changeTeacherActi")//更改活动信息，其中活动名也可能修改，所以传旧名字
    public int Query(VolunteerActivity form,String oldName)
    {
        return VolunteerService.updateTeacherActi(form,oldName);
    }
    @PostMapping("/getStuActi")//获取活动对应的学生信息，方便打分
    public List<StuActiGrade> GetStu(VolunteerActivity form)
    {
        System.out.println(form);
        return VolunteerService.getStuActi(form);
    }
    @PostMapping("/paginateT")//获取教师活动的分页信息
    public ResultVo paginateT(String tName,int page,int size)
    {
        return VolunteerService.paginateT(tName,page,size);
    }
    @PostMapping("/setStuActi")//给学生打分
    public int SetStu(@RequestBody StuActiGrade[] form)
    {
        for(int i=0;i<form.length;i++)
        {
            System.out.println(form[i].getGrade());
        }

        return VolunteerService.setGrade(form);
    }
    @PostMapping("/finish")//给对应的活动结束掉
    public void SetStatus(VolunteerActivity form)
    {
        VolunteerService.setStatus(form);
    }

    @PostMapping("/update")//更新教师的电话号码
    public ResultVo updatePhone(Teacher form)
    {
       return TeacherService.updateTeacherPhone(form);
    }

    @PostMapping("/getAccount")//获取账号信息
    public ResultVo getAccount(String account)
    {
        return TeacherService.getAccount(account);
    }

    @PostMapping("/updatePassword")//修改密码
    public ResultVo updatePassword(Teacher form,String newPassword)
    {
        return TeacherService.updatePassword(form,newPassword);
    }

    @PostMapping("/resetPassword")
    public ResultVo resetPassword(Teacher form,String oldPass)
    {
        return TeacherService.newPassword(form,oldPass);
    }

    @PostMapping("/search")
    public List<VolunteerActivity> search(String name)//根据活动名或教师名搜索
    {

        return VolunteerService.search(name);
    }


}



