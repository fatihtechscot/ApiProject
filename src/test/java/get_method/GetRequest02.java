package get_method;
import static io.restassured.RestAssured.*;
import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class GetRequest02 extends HerokuappBaseUrl {
    /* TC01
     When
     I send a GET Request to the url  https://restful-booker.herokuapp.com/booking/1001
     Then
     HTTP status code should be 404
     And
     content type should be json
     And
     status line should be  HTTP/1.1 404 OK   */
    @Test
    public void get02(){
       // spec.pathParams("first","booking",
       //         "second","10");
        Response response=given().spec(spec).pathParams("first","booking",
                "second","10").when().get("/{first}/{second}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType("application/JSON");
        Assert.assertTrue(response.asString().contains("depositpaid"));
        Assert.assertEquals(response.getContentType(),"application/json; charset=utf-8");

    }
}

