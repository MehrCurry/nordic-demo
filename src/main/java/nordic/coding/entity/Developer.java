package nordic.coding.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@Data
public class Developer {
    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;
    private String programmingLanguage;
}
