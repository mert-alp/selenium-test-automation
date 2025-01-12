import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class PetStoreTest {
    @Test
    public void CreateUser(){
        String bodyPayload = "{\n" +
                "  \"id\": 149,\n" +
                "  \"username\": \"mertalp6\",\n" +
                "  \"firstName\": \"mert\",\n" +
                "  \"lastName\": \"alp\",\n" +
                "  \"email\": \"mert.alp@mail.com\",\n" +
                "  \"password\": \"test123\",\n" +
                "  \"phone\": \"054215555555\",\n" +
                "  \"userStatus\": 1\n" +
                "}";
        RestAssured.given().body(bodyPayload).when().contentType(ContentType.JSON).post("https://petstore.swagger.io/v2/user");
    }
    @Test
    public void GetUser(){
        RestAssured.given().contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/mertalp");
    }
     @Test
    public void UpdateUser(){
        String bodyPayload ="{\n" +
                "  \"id\": 1475649494,\n" +
                "  \"username\": \"mertalp\",\n" +
                "  \"firstName\": \"mert\",\n" +
                "  \"lastName\": \"alpp\",\n" +
                "  \"email\": \"mert.alp@mail.com\",\n" +
                "  \"password\": \"test123\",\n" +
                "  \"phone\": \"054215555555\",\n" +
                "  \"userStatus\": 1\n" +
                "}";
        RestAssured.given().body(bodyPayload).contentType(ContentType.JSON).when().put("https://petstore.swagger.io/v2/user/mertalp");
     }
     @Test
    public void DeleteUser(){
        RestAssured.given().contentType(ContentType.JSON).when().delete("https://petstore.swagger.io/v2/user/mertalp1");
     }
     @Test
    public void UserLogin(){
         Map<String,Object> queryParamsMap= new HashMap<>();
         queryParamsMap.put("username","mertalp");
         queryParamsMap.put("password","test123");
        RestAssured.given().queryParams(queryParamsMap).contentType(ContentType.JSON).when().get("https://petstore.swagger.io/v2/user/login");
     }
     @Test
    public void UserLogout(){
        RestAssured.get("https://petstore.swagger.io/v2/user/logout");
     }


}
