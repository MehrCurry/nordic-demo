package nordic.coding.control;

import nordic.coding.entity.Developer;
import nordic.coding.entity.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class InitializerBean  implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DeveloperRepository repository;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (repository.count()==0) {
            final Developer developer = Developer.builder()
                    .firstname("Guido")
                    .lastname("Zockoll")
                    .email("gzockoll[at]gmail.com")
                    .programmingLanguages("Java,Groovy,JavaScript,Ruby")
                    .build();
            repository.save(developer);
        }
    }
}