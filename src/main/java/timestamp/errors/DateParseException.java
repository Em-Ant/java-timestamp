package timestamp.errors;

import java.text.ParseException;

public class DateParseException extends ParseException {
  private static final long serialVersionUID = 999L;
  public DateParseException(String err, int offset) {
    super(err, offset);
  }
}