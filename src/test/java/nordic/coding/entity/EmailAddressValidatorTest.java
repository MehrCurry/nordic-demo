package nordic.coding.entity;

import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintValidatorContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class EmailAddressValidatorTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void isValid() throws Exception {
        EmailAddressValidator validator=new EmailAddressValidator();
        assertThat(validator.isValid("a@b.com",mock(ConstraintValidatorContext.class))).isTrue();
    }

    @Test
    public void invalidAddress() throws Exception {
        EmailAddressValidator validator=new EmailAddressValidator();
        assertThat(validator.isValid("a@b@com",mock(ConstraintValidatorContext.class))).isFalse();
    }
}