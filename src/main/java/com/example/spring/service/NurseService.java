package com.example.spring.service;

import com.example.spring.others.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import test.Dao.nurseMapper;
import test.pojo.others.Nurse;

import java.util.List;

public class NurseService {
    private static nurseMapper mapper;
    static {
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
        // 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(nurseMapper.class);
    }//给mapper赋值
    public static List<Nurse> selectAll()
    {
        return mapper.selectAll();
    }
    public static List<Nurse> selectByName(String name)
    {
        return mapper.selectByName(name);
    }

    public static void changMsg(int id,String name)
    {
        mapper.changMsg(id,name);
    }
    public static List<Nurse> selectByRoom(String room)
    {
        return mapper.selectByRoom(room);
    }
    public static Nurse selectById(int id) {
        return mapper.selectById(id);
    }

    public static void add(int id,String name,String sex,String job,String room,
                           String phone,String produce){
        mapper.insertJobber(id, name, sex, job, produce,phone ,room );
    }
    public static void update(int id,String name,String sex,String job,String room,
                           String phone,String produce){
        mapper.change(id, name, sex, job, produce,phone ,room );
    }

    public static void delete(int id)
    {
        mapper.delete(id);
    }
    public static List<Nurse> selectP(int start,int end)
    {
        return mapper.selectP(start,end);
    }


}
