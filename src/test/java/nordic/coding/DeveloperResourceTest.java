package nordic.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NordicApplication.class)
@WebIntegrationTest("server.port:0")
public class DeveloperResourceTest {

    @Test
    public void testRest() {
        when().
                get("/developer").
                then().
                statusCode(200);
    }
}
