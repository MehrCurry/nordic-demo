package nordic.coding;

import com.google.common.collect.ImmutableList;
import com.jayway.restassured.RestAssured;
import nordic.coding.entity.Developer;
import nordic.coding.entity.DeveloperRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = NordicApplication.class)
@WebIntegrationTest("server.port:0")
@ActiveProfiles("itest")
public class DeveloperResourceIT {
    @Value("${local.server.port}")
    private int serverPort;

    @Autowired
    private DeveloperRepository repository;
    private Developer dev1;
    private Developer dev2;

    @Before
    public void setUp()
    {
        RestAssured.port = serverPort;
        dev1 = Developer.builder()
                .firstname("JUnit")
                .lastname("Test")
                .build();
        dev1.addLanguages("Java, Ruby, Groovy");
        dev2 = Developer.builder()
                .firstname("Integration")
                .lastname("Test")
                .build();
        dev2.addLanguages("JavaScript, PHP, C++");
        repository.save(ImmutableList.of(dev1, dev2));
    }

    @Test
    public void testRest() {
        when().
                get("/developer/{id}",dev1.getId()).
                then().
                statusCode(200).body("firstname", Matchers.is(dev1.getFirstname()));
    }
}
