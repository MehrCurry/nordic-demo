package nordic.coding.entity;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity extends ValidateableObject {
    @Id
    @GeneratedValue
    @Getter
    private Long id;
}
