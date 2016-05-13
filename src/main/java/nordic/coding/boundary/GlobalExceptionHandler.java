package nordic.coding.boundary;

import nordic.coding.entity.ConstraintViolationProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler implements ConstraintViolationProcessor {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    ResponseEntity<Object> handleControllerException(HttpServletRequest req, ConstraintViolationException ex) {
        String messages=concatenateErrorMessages(ex.getConstraintViolations());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
    }
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    ResponseEntity<Object> defaultHandler(HttpServletRequest req, Throwable t) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(t.getMessage());
    }
}