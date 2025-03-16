package test.Dao;

import org.apache.ibatis.annotations.Param;
import test.pojo.HasGotActi;
import test.pojo.StuActiGrade;
import test.pojo.VolunteerActivity;

import java.util.List;

public interface StuActMapper {

  void add(@Param("account")String account,@Param("activityName")String actName,@Param("tName")String tName);

  String select(@Param("account")String account,@Param("activityName")String actName,@Param("tName")String tName);

  List<HasGotActi> selectByNum(@Param("account")String account);
  void delete(@Param("account")String account,@Param("activityName")String actName,@Param("tName")String tName);

  void deleteByNames (@Param("name")String name,@Param("tName")String tName);
  void updateStuActi(@Param("oldName")String oldName,@Param("activityName")String actName,@Param("tName")String tName);
  List<StuActiGrade> selectByNames(@Param("activityName")String actName,@Param("tName")String tName);

  void deleteByTName(String tName);
  void setGrade(StuActiGrade form);
  List<StuActiGrade> selectByNumG(@Param("account")String account);
  void deleteByStuNum(String account);
  void updateTName(@Param("oldName")String oldName,@Param("newName")String newName);
  List<HasGotActi> searchG(@Param("name") String name,@Param("account") String account,@Param("search")boolean s);

  List<VolunteerActivity> stuActPaginate(@Param("account")String account,@Param("name") String name,
                                         @Param("search") boolean search,@Param("status")String s,
                                         @Param("start") int start,@Param("size")int size);

  String getGrade(@Param("account")String account,@Param("tName") String tName,@Param("activityName") String activityName);
}
