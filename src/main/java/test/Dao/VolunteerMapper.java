package test.Dao;

import org.apache.ibatis.annotations.Param;
import test.pojo.VolunteerActivity;

import java.util.Collection;
import java.util.List;

public interface VolunteerMapper {

  List<VolunteerActivity> selectAll();
  void addNum(@Param("name")String name,@Param("tName")String tName);

  VolunteerActivity selectByNames(@Param("name")String name,@Param("tName")String tName);
  void reduceNum(@Param("name")String name,@Param("tName")String tName);
  List<VolunteerActivity> selectByTName(String tName);
  void insertActi(VolunteerActivity form);
  void deleteByNames(@Param("name")String name,@Param("tName")String tName);
  void updateTeacherActi(@Param("form")VolunteerActivity form,@Param("oldName")String oldName);
  void setStatus(VolunteerActivity form);

  void updateNum(@Param("name")String name,@Param("tName")String tName,@Param("num")int num);
  VolunteerActivity getFinish(@Param("name")String name,@Param("tName")String tName);
  void deleteByTName(String tName);
  void updateTName(@Param("oldName")String oldName,@Param("newName")String newName);
  void updatePhone(@Param("tName")String tName,@Param("phone")String phone);
  List<VolunteerActivity> search(@Param("name")String name);
  List<VolunteerActivity> searchT(@Param("name")String name,@Param("tName")String tName);

  List<VolunteerActivity> paginate(@Param("start")int start,@Param("size") int size,
                                   @Param("name") String name,@Param("isSearch") boolean isSearch);

  List<VolunteerActivity> paginateT(@Param("tName")String tName, @Param("start")int start,@Param("size") int size
                                    );

  void updateAvatar(@Param("tName")String tName,@Param("avatar") String avatar);

  void importInf(@Param("acs")List<VolunteerActivity> acs);
}
