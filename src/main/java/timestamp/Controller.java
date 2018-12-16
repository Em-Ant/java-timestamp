package timestamp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import timestamp.errors.DateParseException;

@RestController
public class Controller {
  private static final String API_TIMESTAMP = "/api/timestamp";
  private static final String API_TIMESTAMP_DATE_STRING = "/api/timestamp/{date_string}";

  @RequestMapping(value = API_TIMESTAMP, method = RequestMethod.GET)
  public Timestamp  now () {
    return new Timestamp();
  } 
  @RequestMapping(value = API_TIMESTAMP_DATE_STRING, method = RequestMethod.GET)
  public Timestamp fromDateString (
    @PathVariable("date_string") String dateString) throws DateParseException {

    try {
      long unix_ts = new Long(dateString);
      return new Timestamp(unix_ts);
    } catch (NumberFormatException e) {
      return new Timestamp(dateString);
    }
  }
}