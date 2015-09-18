package nordic.coding.entity;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface DeveloperRepository extends PagingAndSortingRepository<Developer, Long> {

}
