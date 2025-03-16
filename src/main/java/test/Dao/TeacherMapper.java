package test.Dao;

import org.apache.ibatis.annotations.Param;
import test.pojo.Account;
import test.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> selectAll();
    void deleteByTName(String tName);
    Teacher selectByAccount(@Param("account")String account, @Param("password")String password);
    void register(Teacher teac);
     Teacher selectByPhone(String phone);
     void updateForPhone(Teacher teac);
     void resetPassword(@Param("account")String account, @Param("password") String password);

     Teacher selectByName(String tName);
     void updateName(@Param("account")String account,@Param("tName")String tName);
     Teacher selectByAccountNum(String account);


    void saveInf(Teacher form);

    List<String> getAvatars();
}
