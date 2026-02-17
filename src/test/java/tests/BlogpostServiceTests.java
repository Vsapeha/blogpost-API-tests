package tests;

import assertions.AssertableResponse;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import services.BlogpostService;

import static conditions.Conditions.contentType;
import static conditions.Conditions.statusCode;

public class BlogpostServiceTests extends BaseTest {

    private final BlogpostService blogpostService = new BlogpostService();

    private AssertableResponse response;

    @Test()
    void canGetListOfBlogposts_expect_200() {
        //  when
        response = blogpostService
                .getListOfBlogposts()

        // then
                .shouldHave(statusCode(200))
                .shouldHave(contentType(ContentType.JSON));

        assertions
                .assertBlogpostsServiceResponse(response)
                .shouldHaveBody_getListOfBlogposts();
    }

}
