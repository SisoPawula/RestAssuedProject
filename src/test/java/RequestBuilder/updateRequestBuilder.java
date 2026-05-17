package RequestBuilder;

import io.restassured.response.Response;

import static commons.Paths.BASE_URL;
import static io.restassured.RestAssured.given;

public class updateRequestBuilder {

    public static String adminToken;

    public static Response updateRequest() {
        String apiPath = "APIDEV/testimonials/{{testimonialId}}";

        System.out.println("API path: " + apiPath);
        System.out.println("Admin token" + adminToken);

        return given()
                .baseUri(BASE_URL)
                .basePath(apiPath)
                .pathParams("userID", userRequestBuilder.createTestimonialId)
                .header("Authorization", "Bearer " + adminToken)
                .when()
                .put()
                .then()
                .extract().response();

    }
    public static Response adminLogin(){
        Response response = userRequestBuilder.loginUser("admin@gmail.com", "@12345678");
        adminToken = response.jsonPath().getString("data.token");
        return response;
    }


}
