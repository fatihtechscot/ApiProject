package get_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import static org.junit.Assert.*;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class GetRequest03 extends JsonPlaceHolderBaseUrl {
    /* When
    I send a get request to rest api url https://jsonplaceholder.typicode.com/todos/23
    And accept type is "application/json"
    Then http status should be 200
    And response format should be "application/json"
    And "completed" is false
    And "userid" is 2
     */
    @Test
    public void get01(){
    spec.pathParams("first","todos","second","23");
    Response response=given().spec(spec).when().get("/{first}/{second}");
    response.prettyPrint();
    response.then().assertThat().statusCode(200).
            body("completed", Matchers.equalTo(false)).
            body("userId",Matchers.equalTo(2));
    //false is boolean .So we dont use doublequotes.
    //2ND WAY DO NOT REPEAT BODY AND MATCHERS
        response.then().assertThat().body("id",equalTo(23),
                "userId",equalTo(2));
    //3rd WAY using assertmethods
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("23"));
    }


}
