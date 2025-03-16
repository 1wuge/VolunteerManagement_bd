package test.pojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {


    String account;

    String password;

    String username;
    String email;
    String phone;
    String address;
    int code;
    String avatar;

}
