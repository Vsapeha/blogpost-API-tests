package tests;

import assertions.AssertableResponse;
import io.restassured.http.ContentType;
import model.blogpostService.PostBlogpostPayload;
import model.blogpostService.PutBlogpostPayload;
import org.testng.annotations.Test;
import responses.blogpostsService.Blogpost;
import services.BlogpostService;

import static conditions.Conditions.contentType;
import static conditions.Conditions.statusCode;

public class BlogpostServiceTests extends BaseTest {

    private final BlogpostService blogpostService = new BlogpostService();

    private AssertableResponse response;

    @Test
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

    @Test
    void canCreateBlogpost_expect_201() {
        PostBlogpostPayload payload = PostBlogpostPayload.builder().build();
        //        when
        response = blogpostService
                .createBlogpost(payload)
        //        then
                .shouldHave(statusCode(201))
                .shouldHave(contentType(ContentType.JSON));

        assertions
                .assertBlogpostsServiceResponse(response)
                .shouldHaveBody_postBlogpost(payload.getUserId(), payload.getTitle(), payload.getBody());

    }


    @Test
    void canUpdateBlogpost_expect_200() {
        // Test data
        int blogpostId = 1;
        int updatedUserId = 2;
        String updatedTitle = "UPD title";
        String updatedBody = "UPD body";

        PutBlogpostPayload updatedPayload = PutBlogpostPayload.builder().id(blogpostId)
                .userId(updatedUserId)
                .title(updatedTitle)
                .body(updatedBody).build();

        //        when
        response = blogpostService
                .updateBlogpost(updatedPayload, blogpostId)
        //        then
                .shouldHave(statusCode(200))
                .shouldHave(contentType(ContentType.JSON));

        assertions
                .assertBlogpostsServiceResponse(response)
                .shouldHaveBody_postBlogpost(blogpostId, updatedUserId, updatedTitle, updatedBody);

    }

}
