package com.example.spring.service;

import com.example.spring.Utils.TimeUtil;
import com.example.spring.others.SqlSessionFactoryUtils;
import com.example.spring.vo.ResultVo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import test.Dao.ShareMapper;
import test.Dao.TeacherMapper;
import test.pojo.Share;

public class ShareService  {

    private static ShareMapper mapper;

    static {
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();
        // 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(ShareMapper.class);
    }//给mapper赋值
    public static ResultVo selectAll() {
       return new ResultVo(200,mapper.selectAll(),"成功获取分享消息");
    }

    public static ResultVo addSharing(Share share) {
        share.setTime(TimeUtil.getNowTime());
        mapper.addSharing(share);
        return new ResultVo(200,null,"成功添加");
    }
}
