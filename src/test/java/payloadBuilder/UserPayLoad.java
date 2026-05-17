package payloadBuilder;

import org.json.simple.JSONObject;

public class UserPayLoad {
    public static JSONObject userLoginPayload(String email, String password) {
        JSONObject userLogin = new JSONObject();
        userLogin.put("email", email);
        userLogin.put("password", password);

        return userLogin;
    }

    public static JSONObject createTestimonialPayload(String title, String content, String rating, String isPublic) {
        JSONObject createTestimonial = new JSONObject();
        createTestimonial.put("title", title);
        createTestimonial.put("content", content);
        createTestimonial.put("rating", rating);
        createTestimonial.put("isPublic", isPublic);


        return createTestimonial;
    }

}
