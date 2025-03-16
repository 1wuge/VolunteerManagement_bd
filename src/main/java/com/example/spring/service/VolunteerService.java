package com.example.spring.service;

import com.example.spring.myConst.ActivityConst;
import com.example.spring.others.SqlSessionFactoryUtils;
import com.example.spring.vo.ResultVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import test.Dao.StuActMapper;
import test.Dao.VolunteerMapper;
import test.pojo.*;

import java.util.ArrayList;
import java.util.List;

public class VolunteerService {

    private static VolunteerMapper mapper;
    static {
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
        // 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(VolunteerMapper.class);
    }//给mapper赋值

    private static StuActMapper stuActMapper;
    static {
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
        // 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        stuActMapper = sqlSession.getMapper(StuActMapper.class);
    }//给mapper赋值

    /**
     * 根据分页获取对应的活动
     * @param page
     * @param size
     * @return
     */
    public static ResultVo paginate(int page, int size,String name,boolean isSearch) {

        int start=(page-1)*size;
        String a="%"+name;
        a+="%";
        return new ResultVo(ActivityConst.CODE_OK,mapper.paginate(start,size,a,isSearch),ActivityConst.GET_ACTIVITIES_OK);
    }

    /**
     * 批量删除教师相关的活动
     * @param tName
     * @param names
     * @return
     */
    public static ResultVo delBatch(String tName,String[] names) {

        for(int i=0;i< names.length;i++)
        {
            deleteTeacherActi(names[i],tName);
        }
        return new ResultVo(ActivityConst.CODE_OK,null,null);
    }
    public static ResultVo paginateT(String tName, int page, int size) {
        int start=(page-1)*size;
        return new ResultVo(ActivityConst.CODE_OK,mapper.paginateT(tName,start,size),ActivityConst.GET_ACTIVITIES_OK);
    }
    /**
     * 根据条件查询活动中的活动
     * @param account
     * @param page
     * @param size
     * @param name
     * @param isSearch
     * @return
     */
    public static ResultVo hasGotPaginate(String account,int page, int size,String name,boolean isSearch) {


        String a="%"+name;
        a+="%";
        page=(page-1)*size;
        List<VolunteerActivity> ac=stuActMapper.stuActPaginate(account,a,isSearch,"活动中",page,size);//首先获取该学生所有对应的活动

        if(ac==null)
        {
            return new ResultVo(ActivityConst.CODE_NO,null,ActivityConst.GET_ACTIVITIES_NO);
        }
        return new ResultVo(ActivityConst.CODE_OK,ac,ActivityConst.GET_ACTIVITIES_OK);
    }

    /**
     * 根据条件查已经结束的活动
     * @param account
     * @param page
     * @param size
     * @param name
     * @param isSearch
     * @return
     */
    public static ResultVo hasDonePaginate(String account,int page, int size,String name,boolean isSearch) {

        String a="%"+name;
        a+="%";
        page=(page-1)*size;
        List<VolunteerActivity> ac=stuActMapper.stuActPaginate(account,a,isSearch,"已结束",page,size);//首先获取该学生所有对应的活动
        for(int i=0;i<ac.size();i++)
        {
            ac.get(i).setGrade(stuActMapper.getGrade(account,ac.get(i).getTName(),ac.get(i).getActivityName()));
        }
        if(ac==null)
        {
            return new ResultVo(ActivityConst.CODE_NO,null,ActivityConst.GET_ACTIVITIES_NO);
        }
        return new ResultVo(ActivityConst.CODE_OK,ac,ActivityConst.GET_ACTIVITIES_OK);
    }
    /**
     * 根据条件获取活动的数量
     * @return
     */
    public static ResultVo getNum(String name,boolean isSearch)
    {
        List<VolunteerActivity> all=new ArrayList<>();
        if(!isSearch)
        {
            all=mapper.selectAll();
            for(int i=0;i<all.size();i++)//给活动设置对应的学生数
            {
                int num=stuActMapper.selectByNames(all.get(i).getActivityName(),all.get(i).getTName()).size();
                all.get(i).setNum(num);
                mapper.updateNum(all.get(i).getActivityName(),all.get(i).getTName(),num);
            }
        }

        if(isSearch)
        {
            all=search(name);
        }

        return new ResultVo(ActivityConst.CODE_OK,all.size(),ActivityConst.GET_ACTIVITIES_OK);
    }
    public static int apply(String account,String activityName,String tName)
    {
       if(stuActMapper.select(account,activityName,tName)!=null)
       {
           return 500;
       }
        mapper.addNum(activityName,tName);
        stuActMapper.add(account,activityName,tName);
        return 200;
    }

    /**
     * 根据学生账号查询他所报名的活动，不能是已经结束的活动
     * @param account
     * @return
     */
    public static List<VolunteerActivity> selectByAccount(String account)//通过学生账号查他所有报名的活动
    {
        List<VolunteerActivity> list=new ArrayList<>();
        List<HasGotActi> stu=stuActMapper.selectByNum(account);
        for(int i=0;i<stu.size();i++)//
        {
            if(!mapper.selectByNames(stu.get(i).getActivityName(),stu.get(i).getTName()).getStatus().equals("已结束"))
            {
                list.add(mapper.selectByNames(stu.get(i).getActivityName(),stu.get(i).getTName()));
            }

        }
        return list;
    }

    /**
     * 根据教师名获取对应的活动，一般是教师查自己的活动所用
     * @param tName
     * @return
     */
    public static ResultVo getActNumByTName(String tName)
    {
        return new ResultVo(ActivityConst.CODE_OK,mapper.selectByTName(tName).size(),null);
    }

    public static ResultVo importInf(List<VolunteerActivity> acs)//
    {
        for(int i=0;i<acs.size();i++)
        {
            if(mapper.selectByNames(acs.get(i).getActivityName(),acs.get(i).getTName())!=null)
            {
                acs.remove(acs.get(i));
            }
        }
        mapper.importInf(acs);
        return new ResultVo(ActivityConst.CODE_OK,null,"导入成功");
    }
    /**
     * 更新活动表里的头像
     * @param tName
     * @param avatar
     * @return
     */
    public static ResultVo updateAvatar(String tName,String avatar)
    {
        mapper.updateAvatar(tName,avatar);
        return new ResultVo(ActivityConst.CODE_OK,null,null);
    }

    /**
     * 根据学号，活动名以及教师名删除活动
     * @param account
     * @param activityName
     * @param tName
     * @return
     */
    public static int deleteStuActi(String account,String activityName,String tName)
    {
        stuActMapper.delete(account,activityName,tName);
        mapper.reduceNum(activityName,tName);
        return 200;
    }

    public static VolunteerActivity selectByNames(String activityName,String tName)
    {
        return mapper.selectByNames(activityName,tName);
    }

    public static int applyTeacherActi(VolunteerActivity form)//教师添加志愿活动
    {
        if(mapper.selectByNames(form.getActivityName(),form.getTName())!=null)//说明命名重复了
        {
            return 500;
        }
        else{
            mapper.insertActi(form);
            return 200;
        }
    }

    public static int deleteTeacherActi(String activityName,String tName)//教师删除志愿活动
    {
        mapper.deleteByNames(activityName,tName);//删除活动表里对应的活动
        stuActMapper.deleteByNames(activityName,tName);//同时删除学生已申报活动表里的活动
        return 200;
    }

    public static int updateTeacherActi(VolunteerActivity form,String oldName)//更改活动相关信息，其中活动名称
    {
        if(form.getActivityName().equals(oldName))
        {
            //更改两个表的信息
            mapper.updateTeacherActi(form,oldName);//更改activities表对应的内容
            stuActMapper.updateStuActi(oldName,form.getActivityName(),form.getTName());//更改学生活动表
            return 200;//代表成功
        }
        else{
            if(mapper.selectByNames(form.getActivityName(), form.getTName())!=null)
            {
                return 500;//代表活动名重复
            }
            else{
                //更改两个表的信息
                mapper.updateTeacherActi(form,oldName);//更改activities表对应的内容
                stuActMapper.updateStuActi(oldName,form.getActivityName(),form.getTName());//更改学生活动表
                return 200;//代表成功
            }
        }


    }


    //获取该活动相关学生的信息，用于评分
    public static List<StuActiGrade> getStuActi(VolunteerActivity form)
    {
       List<StuActiGrade> stuA=stuActMapper.selectByNames(form.getActivityName(),form.getTName());
       if(stuA==null)
       {
           return null;
       }
       else{
           for(int i=0;i<stuA.size();i++)
           {
               stuA.get(i).setStudentName(UserService.getName(stuA.get(i).getStudentNum()));
           }
           return stuA;
       }

    }

    public static int setGrade(StuActiGrade[] form)//给对应学生设置评分
    {
        for(int i=0;i<form.length;i++)
        {
            stuActMapper.setGrade(form[i]);
        }
        return 200;
    }

    public static void setStatus(VolunteerActivity form)//教师结束此活动，所以活动状态要设置为已结束
    {
        mapper.setStatus(form);
    }



    public static void deleteByStuNum(String account)//某学生取消参报某活动
    {
        stuActMapper.deleteByStuNum(account);
    }
    public static void deleteByTName(String tName)//教师删除某个活动
    {
        mapper.deleteByTName(tName);
        stuActMapper.deleteByTName(tName);
    }
    public static void updateTName(String oldName,String newName)//更新教师的姓名
    {
        mapper.updateTName(oldName,newName);
        stuActMapper.updateTName(oldName,newName);
    }
    public static void updatePhone(String tName,String phone)//更新该教师的电话
    {
        mapper.updatePhone(tName,phone);
    }

    public static List<VolunteerActivity> search(String name)//根据活动名或教师名搜索活动
    {
        String a="%"+name;
        a+="%";
        return mapper.search(a);
    }

    public static List<VolunteerActivity> searchT(String name,String tName)//根据活动名关键字搜索该教师的活动
    {
        String a="%"+name;
        a+="%";
        return mapper.searchT(a,tName);
    }
    public static ResultVo searchG(String name,String account,boolean isSearch)//搜索该学生对应活动名或教师名的已参加报名的活动
    {
        String a="%"+name;
        a+="%";
        List<VolunteerActivity> list=new ArrayList<>();
        List<HasGotActi> stu=stuActMapper.searchG(a,account,isSearch);//首先获取该学生所有对应的活动
        for(int i=0;i<stu.size();i++)//根据活动名和教师名获取对应的活动信息
        {
            //如果此活动没结束则加入list
            if(!mapper.selectByNames(stu.get(i).getActivityName(),stu.get(i).getTName()).getStatus().equals("已结束"))
            {
                list.add(mapper.selectByNames(stu.get(i).getActivityName(),stu.get(i).getTName()));
            }
        }
        return new  ResultVo(ActivityConst.CODE_OK,list.size(),ActivityConst.GET_ACTIVITIES_OK);
    }
    public static ResultVo  searchD(String name,String account,boolean isSearch)
    {
        String a="%"+name;
        a+="%";
        List<HasGotActi> ac=stuActMapper.searchG(a,account,isSearch);//首先获取该学生所有对应的活动
        List<VolunteerActivity> vo=new ArrayList<>();
        if(ac==null)
        {
            return null;
        }
        else{
            for(int i=0;i<ac.size();i++)
            {
                //如果该活动已经结束就加入
                VolunteerActivity v=mapper.getFinish(ac.get(i).getActivityName(),ac.get(i).getTName());
                if(v!=null)
                {
                    v.setGrade(ac.get(i).getGrade());
                    vo.add(v);
                }
            }
            return new ResultVo(ActivityConst.CODE_OK,vo.size(),ActivityConst.GET_ACTIVITIES_OK);
        }
    }



}
