package nordic.coding.entity;

import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailAddressValidator implements ConstraintValidator<ValidEmailAddress, String> {
    private ValidEmailAddress constraint;

    public void initialize(ValidEmailAddress constraint) {
        this.constraint = constraint;
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
       return EmailValidator.getInstance().isValid(obj);
   }
}
