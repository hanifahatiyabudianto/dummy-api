package tech.atlasid.dummyapiautomation.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorMessage {

  private String errorCode;
  private Integer statusCode;
  private String message;
  private LocalDateTime timestamp;


}
