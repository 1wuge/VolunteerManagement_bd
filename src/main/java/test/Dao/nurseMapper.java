package test.Dao;

import org.apache.ibatis.annotations.Param;
import test.pojo.others.Nurse;

import java.util.List;

public interface nurseMapper {

  void insertJobber(@Param("id")int id,@Param("name")String name,@Param("sex") String sex,@Param("job") String job,
                    @Param("phone")String phone,@Param("produce") String produce, @Param("room")String room);
  void change(@Param("id")int id,@Param("name")String name,@Param("sex") String sex,@Param("job") String job,
                    @Param("phone")String phone,@Param("produce") String produce, @Param("room")String room);
  List<Nurse> selectAll();
  void changMsg(@Param("id")int id,@Param("name")String name);
  List<Nurse> selectByRoom(@Param("room")String room);
  Nurse selectById(@Param("id")int id);
  List<Nurse> selectByName(@Param("name")String name);
  List<Nurse> selectP(@Param("start")int start,@Param("end")int end);

  void delete(@Param("id")int id);




}
