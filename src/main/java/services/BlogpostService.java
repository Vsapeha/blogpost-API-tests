package services;

import assertions.AssertableResponse;
import io.restassured.http.ContentType;
import model.blogpostService.PostBlogpostPayload;

public class BlogpostService extends ApiService {

    public AssertableResponse getListOfBlogposts() {
        return new AssertableResponse(setUp()
                .when()
                .get("/posts"));
    }

    public AssertableResponse createBlogpost(PostBlogpostPayload payload) {
        return new AssertableResponse(setUp()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/posts"));
    }

    public AssertableResponse updateBlogpost(PostBlogpostPayload payload, int id) {
        return new AssertableResponse(setUp()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put(String.format("/posts/%d", id)));
    }

    public AssertableResponse deleteBlogpost(int id) {
        return new AssertableResponse(setUp()
                .when()
                .delete(String.format("/posts/%d", id)));
    }
}
