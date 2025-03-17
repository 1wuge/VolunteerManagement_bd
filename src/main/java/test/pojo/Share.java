package test.pojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Share {


    int id;
    String header;
    String produce;
    String content;
    String account;
    int tOrS;
    String time;
    String username;

}
