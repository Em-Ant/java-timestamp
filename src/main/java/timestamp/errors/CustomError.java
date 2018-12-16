package timestamp.errors;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
class CustomError {
  private String message = "unknown error";
  private int status = HttpStatus.INTERNAL_SERVER_ERROR.value();

  public CustomError (String message) {
    this.message = message;
  }

  public CustomError (String message, HttpStatus status) {
    this.message = message;
    this.status = status.value();
  }
}