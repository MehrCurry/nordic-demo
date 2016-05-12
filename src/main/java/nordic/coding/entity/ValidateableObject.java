package nordic.coding.entity;

import javax.persistence.Transient;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidateableObject {
    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

    public Set<ConstraintViolation<ValidateableObject>> validationErrors() {
        return VALIDATOR.validate(this);
    }

    @Transient
    @org.springframework.data.annotation.Transient public boolean isValid() {
        return validationErrors().size() == 0;
    }

    public void validate() throws ConstraintViolationException {
        Set<ConstraintViolation<ValidateableObject>> errors = validationErrors();
        if (errors.size() > 0) {
            throw new ConstraintViolationException(concatenateErrorMessages(errors), errors);
        }
    }

    public String errorMessagesAsString() {
        return concatenateErrorMessages(validationErrors());
    }

    private String concatenateErrorMessages(Set<ConstraintViolation<ValidateableObject>> errors) {
        return errors.stream().map(cv -> String.format("%s.%s %s",cv.getLeafBean().getClass().getSimpleName(),cv.getPropertyPath(),cv.getMessage())).collect(Collectors.joining(", "));
    }

}
