package reqres;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.ArrayList;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestApi {

	@Test
	public void reqResGetUsers() {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);

		String resource = "page=2";
		String expectedEmail = "byron.fields@reqres.in";
		Response response = RestAssured.given().get("https://reqres.in/api/users?" + resource).then().assertThat()
				.statusCode(200).extract().response();

		// System.out.println(response.getHeaders());
		// System.out.println("Status Code : " + response.statusCode());

		response.prettyPrint();

		JsonPath jsonPath = response.getBody().jsonPath();
		System.out.println("Total is : " + jsonPath.get("total"));
		// System.out.println(jsonPath.get("data.email"));
		ArrayList<Object> emails = jsonPath.get("data.email");
		for (Object email : emails) {
			// System.out.println(email);
			if (String.valueOf(email).equalsIgnoreCase(expectedEmail)) {
				System.out.println("Yes we Found it");
				System.out.println(email);
			}
		}
		extent.createTest("API Req Res")
		  .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		extent.flush();
	}
}
