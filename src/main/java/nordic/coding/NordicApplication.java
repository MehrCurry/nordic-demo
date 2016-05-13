package nordic.coding;

import com.google.common.eventbus.EventBus;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * = Asciidoclet
 *
 * Sample comments that include `source code`.
 *
 * [source,java]
 * --
 * include::./src/main/java/nordic/coding/NordicApplication.java[lines=30..35ope]
 * --
 *
 * [plantuml,EventBus]
 * ....
 * EventBus <.up. SnapshotArea
 * EventBus <.up. S3
 * AssetCreatedEvent <.down. StorageArea
 * AssetCreatedEvent <.down. SnapshotArea
 * AssetCreatedEvent <.down. S3
 * AssetDeletedEvent <.down. StorageArea
 * AssetDeletedEvent <.down. SnapshotArea
 * AssetDeletedEvent <.down. S3
 * ....
 *
 * @author https://github.com/johncarl81[John Ericksen]
 */
@SpringBootApplication
@EnableSpringConfigured
public class NordicApplication implements BeanPostProcessor {
    public static void main(String[] args) {
        SpringApplication.run(NordicApplication.class, args);
    }

    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        eventBus().register(o);
        return o;
    }
}
