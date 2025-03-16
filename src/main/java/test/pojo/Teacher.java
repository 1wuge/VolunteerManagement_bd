package test.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    String account;
    String password;
    String tName;
    String email;
    String phone;
    String address;
    int code;
    String avatar;
}
