package RequestBuilder;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloadBuilder.UserPayLoad;

import static commons.Paths.BASE_URL;
import static io.restassured.RestAssured.given;

public class userRequestBuilder {

    static String createTestimonialId;
    static String userToken;

    public static Response createTestimonial(String title, String content, String rating, String isPublic) {

        String apiPath = "/APIDEV/testimonials";
        Response response = given()
                .baseUri(BASE_URL)
                .basePath(apiPath)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(UserPayLoad.createTestimonialPayload(title,content,rating,isPublic))
                .when()
                .post()
                .then()
                .extract().response();
        createTestimonialId = response.jsonPath().getString("data.id");
        return response;

    }
    public static Response loginUser(String email, String password) {

        String apiPath = "/APIDEV/login";
        Response response = given()
                .baseUri(BASE_URL)
                .basePath(apiPath)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(UserPayLoad.userLoginPayload(email, password))
                .post()
                .then()
                .extract().response();
        userToken = response.jsonPath().getString("data.token");
        return response;

    }
}
