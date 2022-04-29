package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseApiClient {

    Gson gson = new GsonBuilder().
            create();
    RequestSpecification reqSpec;
    String baseUrl;

    public BaseApiClient() {
        reqSpec = given().
                header("token", "6113e908022ae8994ed5736c0a5314d3ebc16fd5").
                header("Content-Type", "application/json").
                log().all();
        baseUrl = "https://api.qase.io/v1/";
    }

    public void post(String body, String uri) {
        reqSpec.
                body(body).
                when().
                post(baseUrl + uri).
                then().
                log().all().
                statusCode(200);
    }

    public Response get(String uri) {
        return
                reqSpec.
                        when().
                        get(baseUrl + uri).
                        then().
                        log().all().
                        statusCode(200).
                        extract().response();
    }
}
