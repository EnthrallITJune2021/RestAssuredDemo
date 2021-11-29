package reqres;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class YouTubePOST {

    public static void main(String[] args) {
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\"context\":{\"client\":{\"hl\":\"en\",\"gl\":\"US\",\"remoteHost\":\"100.33.53.208\",\"deviceMake\":\"\",\"deviceModel\":\"\",\"visitorData\":\"CgtvQVNTVE80OWVBdyjn8pCNBg%3D%3D\",\"userAgent\":\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36,gzip(gfe)\",\"clientName\":\"WEB\",\"clientVersion\":\"2.20211124.00.00\",\"osName\":\"Windows\",\"osVersion\":\"10.0\",\"originalUrl\":\"https://www.youtube.com/\",\"screenPixelDensity\":2,\"platform\":\"DESKTOP\",\"clientFormFactor\":\"UNKNOWN_FORM_FACTOR\",\"configInfo\":{\"appInstallData\":\"COfykI0GEJPqrQUQt8utBRCR160FELDUrQUQjemtBRCR-PwSENi-rQU%3D\"},\"screenDensityFloat\":1.5,\"timeZone\":\"America/New_York\",\"browserName\":\"Chrome\",\"browserVersion\":\"96.0.4664.45\",\"screenWidthPoints\":2294,\"screenHeightPoints\":319,\"utcOffsetMinutes\":-300,\"userInterfaceTheme\":\"USER_INTERFACE_THEME_LIGHT\",\"connectionType\":\"CONN_CELLULAR_4G\",\"memoryTotalKbytes\":\"8000000\",\"mainAppWebInfo\":{\"graftUrl\":\"https://www.youtube.com/\",\"webDisplayMode\":\"WEB_DISPLAY_MODE_BROWSER\",\"isWebNativeShareAvailable\":true}},\"user\":{\"lockedSafetyMode\":false},\"request\":{\"useSsl\":true,\"consistencyTokenJars\":[{\"encryptedTokenJarContents\":\"AGDxDeNYYUqS6KtkgG3ex7g4yCV_CCkfinrIRUG9jZYuxzioBAzoEv1Zjk9cZuX0PayELKOEdSasTTw9ixuAOeuo7gQ-u1JbkznzACwoketdyjG3dc5C8zoqRFo8ywuPvAPsnq7pYQf_uqqEaPsvVdVo\"}],\"internalExperimentFlags\":[]},\"clickTracking\":{\"clickTrackingParams\":\"CDQQ384DGAUiEwjLxrHnwbz0AhVO6GAKHT3iBLg=\"},\"adSignalsInfo\":{\"params\":[{\"key\":\"dt\",\"value\":\"1638152551815\"},{\"key\":\"flash\",\"value\":\"0\"},{\"key\":\"frm\",\"value\":\"0\"},{\"key\":\"u_tz\",\"value\":\"-300\"},{\"key\":\"u_his\",\"value\":\"2\"},{\"key\":\"u_h\",\"value\":\"960\"},{\"key\":\"u_w\",\"value\":\"2294\"},{\"key\":\"u_ah\",\"value\":\"920\"},{\"key\":\"u_aw\",\"value\":\"2294\"},{\"key\":\"u_cd\",\"value\":\"30\"},{\"key\":\"bc\",\"value\":\"31\"},{\"key\":\"bih\",\"value\":\"319\"},{\"key\":\"biw\",\"value\":\"2278\"},{\"key\":\"brdim\",\"value\":\"0,0,0,0,2294,0,2294,920,2294,319\"},{\"key\":\"vis\",\"value\":\"1\"},{\"key\":\"wgl\",\"value\":\"true\"},{\"key\":\"ca_type\",\"value\":\"image\"}],\"bid\":\"ANyPxKri1b_Uk4rLsbrC7y5pieMu2vAQRJGhcmFvwJfHqoZjLBMig5f47u28Jka-Q4pVTeZq4bFKqZT3FxxR_yGwgugvvPES-Q\"}},\"continuation\":\"4qmFsgLNAhIPRkV3aGF0X3RvX3dhdGNoGpwCaWdNa01pSkRaM05MUTFNNWRFeDZRWHBoUjFKcFdtaHZTVlpJU21oaFYzaHNZMjVOSlRORXdnU3FBVWRMVDFvMkxXWkNkbEJSUTFkdGQwdGhaMjlhWlZoU1ptTkhSbTVhVmpsNlltMUdkMk15YUhaa1JqbDVXbGRrY0dJeU5XaGlRa2xtWWpObmVGUnRSVEZoTTBaUFZHeFdWMWt3Y0hobFZHeFpXa1ZvYTFOdFpIbFJhMFpVVjFSR2IxbDRiM05CUVVKc1ltZEJRbFpXVFVGQlZsWlVRVUZGUVZKclZqTmhSMFl3V0ROU2RsZ3paR2hrUjA1dlFVRkZRVUZSUlVGQlFVVkJRVkZCUVVGUlNHRXRjeTFWUTJkSlNVRkKaAhpicm93c2UtZmVlZEZFd2hhdF90b193YXRjaA%3D%3D\"}")
                .when()
                .post("https://www.youtube.com/youtubei/v1/browse?key=AIzaSyAO_FJ2SlqU8Q4STEHLGCilw_Y9_11qcW8")
                .then().statusCode(200)
                .extract().response();

        response.prettyPrint();


    }
}