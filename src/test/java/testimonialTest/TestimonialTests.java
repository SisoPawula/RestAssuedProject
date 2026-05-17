package testimonialTest;

import RequestBuilder.userRequestBuilder;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestimonialTests {

    static String title;
    static String content;
    static String rating;
    static String isPublic;

    static Faker faker = new Faker();

    @Test
    public void createTestimonialTest() {
        Response response = userRequestBuilder.createTestimonial(title, content, rating, isPublic);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 201);

    }
}
