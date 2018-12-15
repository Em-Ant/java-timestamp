package timestamp;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Date;

import lombok.Getter;
import timestamp.errors.DateParseException;

@Getter
public class Timestamp {
  private final long unix;
  private final String utc;

  public Timestamp() {
    Date d = new Date();
    this.unix = d.getTime();
    this.utc = d.toString();
  }

  public Timestamp(String s) throws DateParseException {
    Instant i;
    if (s == null) {
      i = Instant.now();
    } else {
      try {
        i = Instant.parse(s);
      } catch (DateTimeParseException e) {
        throw new DateParseException(e.getMessage(), e.getErrorIndex());
      }
    } 
    this.unix = i.toEpochMilli();
    this.utc = i.toString();
  }

  public Timestamp (long unix_ts) {
    Date d = new Date(unix_ts);
    this.unix = d.getTime();
    this.utc = d.toString();
  }
}