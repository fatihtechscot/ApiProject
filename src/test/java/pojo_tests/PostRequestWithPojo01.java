package pojo_tests;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.TodosPojo;
import utils.JsonUtil;

public class PostRequestWithPojo01 extends JsonPlaceHolderBaseUrl {
    /*
       When
            I send POST Request to the URL https://jsonplaceholder.typicode.com/todos
            with Post Request body  {
                                       "userId": 21,
                                       "id": 201,
                                       "title": "Tidy your room",
                                       "completed": false
                                    }
        Then
            Status code is 201
            And response body is like {
                                       "userId": 21,
                                       "id": 201,
                                       "title": "Tidy your room",
                                       "completed": false
                                     }
    */
    @Test
    public void post01() {
        //1)Set the url
        spec.pathParam("first", "todos");
        //2)Set the expected data
        TodosPojo expectedPojo= new TodosPojo(21,"tidy your room",false);
        //3)send the request
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedPojo).post("/{first}");
        response.prettyPrint();
        //4)Assert the output
        //1st way:use gson to convert response body to TodosPojo
        TodosPojo actualPojo=response.as(TodosPojo.class);
        assertEquals(expectedPojo.getTitle(),actualPojo.getTitle());
        //2nd way objectMapper
        TodosPojo actualPojo2= JsonUtil.convertJsonToJava(response.asString(),TodosPojo.class);
    }   //assertEquals(expectedPojo.getTitle(),actualPojo2.getTitle());
}