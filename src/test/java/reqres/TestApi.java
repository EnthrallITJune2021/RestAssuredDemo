package reqres;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestApi {
    public static void main(String[] args) {
        Response response = RestAssured.
                when().get("https://reqres.in/api/users?page=2").
                then().assertThat().statusCode(200).
                extract().response();

        response.prettyPrint();
    }
}
