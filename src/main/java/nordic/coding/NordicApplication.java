package nordic.coding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class NordicApplication {
    public static void main(String[] args) {
        SpringApplication.run(NordicApplication.class, args);
    }
}
