package test.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import test.pojo.Share;

import java.util.List;

public interface ShareMapper  {
     List<Share> selectAll();

     void addSharing(Share share);
}
