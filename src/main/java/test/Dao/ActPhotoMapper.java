package test.Dao;

import org.apache.ibatis.annotations.Param;
import test.pojo.Teacher;

import java.util.List;

public interface ActPhotoMapper {

    void addPhotos(@Param("tName") String tName,@Param("act") String activityName,@Param("photos") String[] photos);
}
