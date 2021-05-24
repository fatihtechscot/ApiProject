package get_method;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.junit.Test;

public class GetRequest01 {
    /* TC01
     When
     I send a GET Request to the url  https://restful-booker.herokuapp.com/booking/3
     Then
     HTTP status code should be 200
     And
     content type should be json
     And
     status line should be  HTTP/1.1 200 OK ?fatih   */
    @Test
    public  void get01(){
        //set the url
        //set the expected data
        //assert the output
        String url= "https://restful-booker.herokuapp.com/booking/3";
        Response response =given().when().get(url);
        response.prettyPrint();
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/JSON");
    }


}
