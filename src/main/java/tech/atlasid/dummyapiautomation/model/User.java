package tech.atlasid.dummyapiautomation.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private String id;
  private String firstName;
  private String lastName;
  private Integer age;
  private String occupation;
  private String nationality;
  private List<String> hobbies;
  private Gender gender;
  private LocalDateTime createdDate;
  private LocalDateTime updatedDate;
}
