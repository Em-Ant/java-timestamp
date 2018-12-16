package timestamp.errors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CustomErrorController implements ErrorController {

  @RequestMapping("/error")
  CustomError sendError(HttpServletRequest request) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    if (status != null) {
      Integer statusCode = Integer.valueOf(status.toString());
   
      if(statusCode == HttpStatus.NOT_FOUND.value()) {
          return new CustomError("not found", HttpStatus.NOT_FOUND);
      }
    }
    return new CustomError("internal server error");
  }
  @Override
  public String getErrorPath() {
    return "/error";
  }
}