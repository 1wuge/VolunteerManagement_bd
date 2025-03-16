package test.Dao;

import org.apache.ibatis.annotations.Param;
import test.pojo.Account;

import java.util.List;

public interface AccountMapper {

    List<Account> selectAll();
    Account selectByAccountNum(String account);
    Account selectByAccount(@Param("account")String account, @Param("password")String password);
    void register(@Param("account")String a,@Param("username") String u, @Param("password") String p,@Param("avatar") String av);
    String getStuName(String account);
    void deleteByAccount(String account);
    void resetPassword(@Param("account")String account, @Param("password") String password);
    void updateName(@Param("account")String account,@Param("username") String username );
    void saveInf(Account account);


}
