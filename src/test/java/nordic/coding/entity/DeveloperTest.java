package nordic.coding.entity;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by gzockoll on 08/03/16.
 */
public class DeveloperTest {

    @Test
    public void aSimpleTest() {
        Developer dev = Developer.builder().firstname("JUnit").lastname("Test").build();
        assertThat(dev.getFirstname()).isEqualTo("JUnit");
        assertThat(dev.getLastname()).isEqualTo("Test");
    }

}
