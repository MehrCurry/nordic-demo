package nordic.coding.entity;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by gzockoll on 08/03/16.
 */
public class DeveloperTest {

    @Test
    public void aSimpleTest() {
        Developer dev = Developer.builder()
                .firstname("JUnit")
                .lastname("Test")
                .build();
        dev.addLanguages("Java, Ruby");
        assertThat(dev.getFirstname()).isEqualTo("JUnit");
        assertThat(dev.getLastname()).isEqualTo("Test");
        Set<String> languages = new HashSet<>(Arrays.asList(dev.getProgrammingLanguages().split(",")));
        assertThat(languages).contains("Java");
        assertThat(languages).doesNotContain("Scala");
        assertThat(languages.size()).isEqualTo(2);
        assertThat(dev.getId()).isNull();

        dev.addLanguages("Groovy, Closure");
        assertThat(dev.getLanguages()).contains("Groovy");
        assertThat(dev.getLanguages()).doesNotContain("Scala");
        assertThat(dev.getLanguages().size()).isEqualTo(4);
    }

    @Test
    public void emptyLanguagesTest() {
        Developer dev = Developer.builder()
                .firstname("JUnit")
                .lastname("Test")
                .build();

        assertThat(dev.getLanguages()).hasSize(0);
    }

    @Test
    public void getLanguagesTest() {
        Developer dev = Developer.builder()
                .firstname("JUnit")
                .lastname("Test")
                .build();
        dev.addLanguages("Java, Groovy, C");

        assertThat(dev.getLanguages()).hasSize(3);
    }
}
