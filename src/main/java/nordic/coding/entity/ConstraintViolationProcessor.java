package nordic.coding.entity;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

public interface ConstraintViolationProcessor {
    default String concatenateErrorMessages(Set<ConstraintViolation<?>> errors) {
        return errors.stream().map(cv -> String.format("%s.%s %s",cv.getLeafBean().getClass().getSimpleName(),cv.getPropertyPath(),cv.getMessage())).collect(Collectors.joining(", "));
    }
}
