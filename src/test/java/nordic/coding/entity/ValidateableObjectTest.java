package nordic.coding.entity;

import lombok.Data;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by guido on 12.05.16.
 */
public class ValidateableObjectTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void validationErrors() throws Exception {
        SomeEntity e = new SomeEntity();
        assertThat(e.validationErrors()).hasSize(2);

        e.setTest1("bla");
        assertThat(e.validationErrors()).hasSize(1);

        e.setTest2("b");
        assertThat(e.validationErrors()).hasSize(2);

        e.setTest2("bla");
        assertThat(e.validationErrors()).hasSize(1);

        e.setTest3("bla@bla.com");
        assertThat(e.validationErrors()).hasSize(0);

        e.setTest3("bla@bla@com");
        assertThat(e.validationErrors()).hasSize(1);

    }

    @Test
    public void isValid() throws Exception {
        SomeEntity e = new SomeEntity();
        assertThat(e.isValid()).isFalse();

        e.setTest1("bla");
        assertThat(e.isValid()).isFalse();

        e.setTest2("b");
        assertThat(e.isValid()).isFalse();

        e.setTest2("bla");
        assertThat(e.isValid()).isFalse();

        e.setTest3("bla@bla.com");
        assertThat(e.isValid()).isTrue();

        e.setTest3("bla@bla@com");
        assertThat(e.isValid()).isFalse();

    }

    @Test
    public void validate() throws Exception {
        SomeEntity e = new SomeEntity();
        thrown.expect(ConstraintViolationException.class);
        e.validate();
    }

    @Data
    public class SomeEntity extends ValidateableObject {
        @NotNull
        private String test1;
        @Size(min = 2)
        private String test2;
        @ValidEmailAddress
        private String test3;
    }

}