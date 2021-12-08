package reqres;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class YouTubePOST {
	
	@Test(enabled = false)
    public void postYouTube() throws IOException {
		InputStream reader = new FileInputStream("youtube.json");
		JSONTokener tokener = new JSONTokener(reader);
		JSONObject object = new JSONObject(tokener);
		String json = object.toString();
				//JsonParser.parseReader(reader).toString();
		System.out.println(json);
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("https://www.youtube.com/youtubei/v1/browse?key=AIzaSyAO_FJ2SlqU8Q4STEHLGCilw_Y9_11qcW8");

        response.prettyPrint();
    }
	
	@Test
	public void jsonManupulation() throws FileNotFoundException {
		InputStream reader = new FileInputStream("youtube.json");
		JSONTokener tokener = new JSONTokener(reader);
		JSONObject object = new JSONObject(tokener);
		System.out.println(object.getJSONObject("context").getJSONObject("request").get("useSsl"));
		System.out.println(object.keySet());
		
		object.getJSONObject("context").getJSONObject("request").put("useSsl", "false");
		
		System.out.println(object.getJSONObject("context").getJSONObject("request").get("useSsl"));
		object.getJSONObject("context").getJSONObject("client").put("useSsl", "somethingelse");
		String device = System.getProperty("os.name");
		System.out.println("This is the current device : " + device);
		object.getJSONObject("context").getJSONObject("client").put("deviceMake", device);
		System.out.println(object);

	}
}
