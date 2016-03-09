package nordic.coding.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Data()
public class Developer {
    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;
    private final Set<String> programmingLanguages=new HashSet<>();

    public void addLanguages(String languages) {
        programmingLanguages.addAll(Arrays.asList(languages.split(",")));
    }

    public void addLanguages(Collection<String> languages) {
        programmingLanguages.addAll(languages);
    }
}
