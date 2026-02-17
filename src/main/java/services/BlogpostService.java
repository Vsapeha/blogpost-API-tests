package services;

import assertions.AssertableResponse;

public class BlogpostService extends ApiService {

    public AssertableResponse getListOfBlogposts() {
        return new AssertableResponse(setUp()
                .when()
                .get("/posts"));
    }
}
