package nordic.coding.entity;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "developer", path = "developer")
public interface DeveloperRepository extends Repository<Developer, Long> {

}
