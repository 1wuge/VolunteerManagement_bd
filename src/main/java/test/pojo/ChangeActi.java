package test.pojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeActi {
    String activityName;
    String startTime;
    String stopTime;
    String address;
    String tName;
    String phone;
    String content;
    int sum;
    int num;
    String status;
    String oldName;

}
