package nordic.coding.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Developer extends AbstractEntity {

    @Size(min = 2)
    private String firstname;
    @Size(min = 2)
    private String lastname;
    private String programmingLanguages;
    @ValidEmailAddress
    private String email;

    public void addLanguages(String languages) {
        List<String> strings = Arrays.asList(languages.split(","));
        addLanguages(strings);
    }

    public void addLanguages(Collection<String> languages) {
        Set<String> all = getLanguages();
        all.addAll(languages);
        programmingLanguages=all.stream().collect(Collectors.joining(","));
    }

    @Transient
    public Set<String> getLanguages() {
        String[] split = (programmingLanguages!=null) ? programmingLanguages.split(",") : new String[0];
        return (split!=null) ? new HashSet<>(Arrays.asList(split)) : new HashSet<String>();
    }
}
