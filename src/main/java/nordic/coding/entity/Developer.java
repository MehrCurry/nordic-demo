package nordic.coding.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Builder
@Data
public class Developer {
    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;
    private String programmingLanguages;

    public void addLanguages(String languages) {
        List<String> strings = Arrays.asList(languages.split(","));
        addLanguages(strings);
    }

    public void addLanguages(Collection<String> languages) {
        Set<String> all = getLanguages();
        all.addAll(languages);
        programmingLanguages=all.stream().collect(Collectors.joining(","));
    }

    public Set<String> getLanguages() {
        String[] split = (programmingLanguages!=null) ? programmingLanguages.split(",") : new String[0];
        return (split!=null) ? new HashSet<>(Arrays.asList(split)) : Collections.EMPTY_SET;
    }
}
