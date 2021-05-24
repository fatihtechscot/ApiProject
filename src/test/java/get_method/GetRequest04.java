package get_method;
import static io.restassured.RestAssured.*;
import base_urls.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

public class GetRequest04 extends RestfulBaseUrl {

    @Test
    public void get01(){
        Response response=given().spec(spec).
                pathParams("first","booking","second","2").when().get("/{first}/{second}");
        response.prettyPrint();
        response.then().assertThat().contentType(ContentType.JSON).
             body("firstname", Matchers.contains("Mark"));

    }

}
