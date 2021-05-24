package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuappBaseUrl {
    //CREATE RequestSpecification object
    protected RequestSpecification spec;
    //BEFORE Annotation :the method will be executed before every test method
    @Before
    //inside before ANNOTATION ,there is a main method.
    public void setUp() {
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

    }
}
