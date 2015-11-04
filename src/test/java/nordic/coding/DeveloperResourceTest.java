package nordic.coding;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NordicApplication.class)
@WebAppConfiguration
public class DeveloperResourceTest {

    @Test
    public void testRest() {
        when().
                get("/developers").
                then().
                statusCode(200);
    }
}
