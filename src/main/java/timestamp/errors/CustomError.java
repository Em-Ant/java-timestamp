package timestamp.errors;

import lombok.Getter;

@Getter
class CustomError {
  private final String message;

  public CustomError (String message) {
    this.message = message;
  }
}