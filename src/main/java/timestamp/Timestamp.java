package timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    Date d;
    if (s == null) {
      d = new Date();
    } else {
      try {
        SimpleDateFormat f = new SimpleDateFormat("yyy-MM-dd");
        d = f.parse(s);
      } catch (ParseException e) {
        throw new DateParseException();
      } catch (IllegalArgumentException i) {
        throw new DateParseException();
      }
    } 
    this.unix = d.getTime();
    this.utc = d.toString();
  }

  public Timestamp (long unix_ts) {
    Date d = new Date(unix_ts);
    this.unix = d.getTime();
    this.utc = d.toString();
  }
}