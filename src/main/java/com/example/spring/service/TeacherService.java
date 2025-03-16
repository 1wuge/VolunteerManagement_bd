package com.example.spring.service;

import com.example.spring.Utils.EmailUtil;
import com.example.spring.myConst.AccountConst;
import com.example.spring.others.SqlSessionFactoryUtils;
import com.example.spring.vo.ResultVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import test.Dao.TeacherMapper;
import test.pojo.Teacher;

import java.util.List;

public class TeacherService {

    private static TeacherMapper mapper;

    static {
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
        // 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(TeacherMapper.class);
    }//给mapper赋值


    public static ResultVo getAccount(String account)//获取用户信息
    {
        return new ResultVo(AccountConst.CODEOK,mapper.selectByAccountNum(account), AccountConst.CHANGE_INF_SUCCESS);
    }
    public static ResultVo updateAvatar(String path)
    {
            return null;
    }

    public static Teacher selectByAccount(String account, String password)//查找对应用户,用于登录
    {

        Teacher ac=mapper.selectByAccount(account,password);
        if(ac==null)
        {
            ac=new Teacher();
            ac.setCode(500);
        }
        else{
            ac.setCode(300);
        }
        return ac;
    }


    public static List<Teacher> selectAll()
    {
        return mapper.selectAll();
    }
    public static ResultVo updateTeacherPhone(Teacher form)//修改教师号码
    {
        if(mapper.selectByPhone(form.getPhone())!=null)
        {
            return new ResultVo(AccountConst.CODENO,null,AccountConst.SAME_PHONE);
        }

        mapper.updateForPhone(form);
        VolunteerService.updatePhone(form.getTName(), form.getPhone());
        return new ResultVo(AccountConst.CODEOK,null,AccountConst.CHANGE_INF_SUCCESS);
    }
    public static void resetPassword(Teacher form)//管理员重置密码
    {
        mapper.resetPassword(form.getAccount(),"87654321");
    }
    public static ResultVo newPassword(Teacher form,String oldPass)//设置新密码
    {
        if(mapper.selectByAccount(form.getAccount(), oldPass)==null)//密码错误
        {
            return new ResultVo(AccountConst.CODENO,null,"密码错误");
        }
        mapper.resetPassword(form.getAccount(), form.getPassword());
        return new ResultVo(AccountConst.CODEOK,null,AccountConst.CHANGE_INF_SUCCESS);
    }
    public static void deleteByTName(String tName)
    {
        mapper.deleteByTName(tName);
    }
    public static ResultVo changeTName(Teacher teac,String newName)
    {
        if(mapper.selectByName(newName)!=null)//说明新名字已经存在
        {
            return new ResultVo(AccountConst.CODENO,null,AccountConst.NAME_EXIST);
        }
        else{
            mapper.updateName(teac.getAccount(),newName);
            VolunteerService.updateTName(teac.getTName(), newName);
            return new ResultVo(AccountConst.CODEOK,null,AccountConst.CHANGE_INF_SUCCESS);
        }
    }
    public static ResultVo applyTeacher(Teacher teac)
    {
        if(mapper.selectByName(teac.getTName())!=null)//说明重复命名了
        {
            return new ResultVo(AccountConst.CODESAMEPASS,null,"");
        } else if (mapper.selectByPhone(teac.getPhone())!=null) //号码存在
        {
            return new ResultVo(AccountConst.CODEVUE,null,"");
        }else if (mapper.selectByAccountNum(teac.getAccount())!=null) {
            return new ResultVo(AccountConst.CODENO,null,"");
        }
        else{
            mapper.register(teac);
            return new ResultVo(AccountConst.CODEOK,null,"");
        }
    }
    public static ResultVo updatePassword(Teacher form,String newPassword)
    {
        if(mapper.selectByAccount(form.getAccount(),form.getPassword())==null)
        {
            return new ResultVo(AccountConst.CODENO,null,"");
        }
        else if(newPassword.equals(form.getPassword()))
        {
            return new ResultVo(AccountConst.CODESAMEPASS,null,"");
        }
        else {
            mapper.resetPassword(form.getAccount(),newPassword);
            return new ResultVo(AccountConst.CODEOK,null,"");
        }
    }

    public static ResultVo saveInf(Teacher form) {
        if(!EmailUtil.isValidEmail(form.getEmail()))//如果格式不对
        {
            return new ResultVo(AccountConst.CODENO,null, AccountConst.EMAIL_FAIL);
        }
        if(form.getPhone().length()>11||form.getPhone().length()<8)//如果号码格式不对
        {
            return new ResultVo(AccountConst.CODENO,null, AccountConst.PHONE_NUM_NO);
        }
        mapper.saveInf(form);
        VolunteerService.updateAvatar(form.getTName(), form.getAvatar());
        return new ResultVo(AccountConst.CODEOK,null, AccountConst.CHANGE_INF_SUCCESS);
    }

    public static List<String> getAvatars()
    {
        return mapper.getAvatars();
    }
}
