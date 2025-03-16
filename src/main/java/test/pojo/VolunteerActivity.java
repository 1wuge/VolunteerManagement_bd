package test.pojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerActivity {
    String activityName;
    String startTime;
    String stopTime;
    String address;
    String tName;
    String phone;
    String content;
    String avatar;
    int sum;
    int num;
    String status;
    String grade;

}
