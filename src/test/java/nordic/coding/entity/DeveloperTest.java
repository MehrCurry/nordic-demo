package nordic.coding.entity;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

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
        Set<String> languages = dev.getProgrammingLanguages();
        assertThat(languages).contains("Java");
        assertThat(languages).doesNotContain("Scala");
        assertThat(languages.size()).isEqualTo(2);
        assertThat(dev.getId()).isNull();

        dev.addLanguages("Groovy, Closure");
        assertThat(languages).contains("Groovy");
        assertThat(languages).doesNotContain("Scala");
        assertThat(languages.size()).isEqualTo(4);
    }
}
