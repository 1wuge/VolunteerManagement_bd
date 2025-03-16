package test.pojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StuActiGrade {
    String studentNum;
    String activityName;
    String tName;
    String grade;
    String studentName;
}
