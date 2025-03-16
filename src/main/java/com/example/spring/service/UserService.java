package com.example.spring.service;

import com.example.spring.Utils.EmailUtil;
import com.example.spring.myConst.AccountConst;
import com.example.spring.myConst.ActivityConst;
import com.example.spring.vo.ResultVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import test.Dao.AccountMapper;
import com.example.spring.others.SqlSessionFactoryUtils;
import test.pojo.Account;

import java.util.List;

public class UserService {

    private static AccountMapper mapper;
    public static String defaultAvatar="./img/默认.jpg";
    static {
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
        // 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(AccountMapper.class);
    }//给mapper赋值

    public static boolean selectByAccountNum(String account)
    {
        if(mapper.selectByAccountNum(account)==null)//判断是否存在该账号
        {
            return false;
        }
        else{
            return true;
        }
    }
    public static ResultVo register(String account,String username,String password)//注册账户
    {
        if(selectByAccountNum(account))//该账号已经存在
        {
            return new ResultVo(AccountConst.CODENO,null, AccountConst.ACCOUNT_EXIST);
        }
        else{
            mapper.register(account,username,password,defaultAvatar);//注册账户
            return new ResultVo(AccountConst.CODEOK,null, AccountConst.REGISTER_SUCCESS);
        }


    }


    public static Account selectByAccount(String account, String password)//查找对应用户,用于登录
    {

        Account ac=mapper.selectByAccount(account,password);
        if(ac==null)//不存在返回code500
        {
            ac=new Account();
            ac.setCode(500);
        }
        else{
            ac.setCode(200);
        }
        return ac;
    }

    public static ResultVo getAccount(String account)//获取用户信息
    {
        return new ResultVo(AccountConst.CODEOK,mapper.selectByAccountNum(account), AccountConst.CHANGE_INF_SUCCESS);
    }
    public static ResultVo saveInf(Account account)//修改相关信息
    {
        if(!EmailUtil.isValidEmail(account.getEmail()))//如果格式不对
        {
            return new ResultVo(AccountConst.CODENO,null, AccountConst.EMAIL_FAIL);
        }
        if(account.getPhone().length()>11||account.getPhone().length()<8)//如果号码格式不对
        {
            return new ResultVo(AccountConst.CODENO,null, AccountConst.PHONE_NUM_NO);
        }
        mapper.saveInf(account);

        return new ResultVo(AccountConst.CODEOK,null, AccountConst.CHANGE_INF_SUCCESS);
    }
    public static ResultVo updatePassword(Account form, String newPassword)//更新学生的密码
    {
        if(mapper.selectByAccount(form.getAccount(),form.getPassword())==null)//密码不对
        {
            return new ResultVo(AccountConst.CODENO,null,"密码错误");
        }
        else if(newPassword.equals(form.getPassword()))//新旧密码一致
        {
            mapper.updateName(form.getAccount(), form.getUsername());
            return new ResultVo(AccountConst.CODESAMEPASS,null, AccountConst.SAME_PASSWORD);
        }
        else {
            mapper.updateName(form.getAccount(), form.getUsername());
            mapper.resetPassword(form.getAccount(), newPassword);
            return new ResultVo(AccountConst.CODEOK,null, AccountConst.CHANGE_PASS_SUCCESS);
        }
    }

    public static List<Account> selectAll()//获取所有学生账户
    {
        return mapper.selectAll();
    }
    public static String getName(String account)//获取对应账户的学生名字
    {
        return mapper.getStuName(account);
    }
    public static void deleteByAccount(String account)//删除该学生账户
    {
        mapper.deleteByAccount(account);
    }
    public static void resetPassword(Account account)//管理员重置学生密码
    {
        mapper.resetPassword(account.getAccount(),"12345678");
    }



}
