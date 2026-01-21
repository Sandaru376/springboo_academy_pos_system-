import com.springbootacademy.pos_system.exception.NotFoundException;
import com.springbootacademy.pos_system.util.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e) {

    StandardResponse response = new StandardResponse(
            404,
            "ERROR",
            e.getMessage()
    );

    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }
}
