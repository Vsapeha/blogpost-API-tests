package tests;

import assertions.AssertableResponse;
import io.restassured.http.ContentType;
import model.blogpostService.PostBlogpostPayload;
import model.blogpostService.PutBlogpostPayload;
import org.testng.annotations.Test;
import services.BlogpostService;

import static conditions.Conditions.contentType;
import static conditions.Conditions.statusCode;

public class BlogpostServiceTests extends BaseTest {

    private final BlogpostService blogpostService = new BlogpostService();

    private AssertableResponse response;

    private final int blogpostId = 1;

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
        PutBlogpostPayload updatedPayload = PutBlogpostPayload.builder().id(blogpostId).build();

        //        when
        response = blogpostService
                .updateBlogpost(updatedPayload, blogpostId)
                //        then
                .shouldHave(statusCode(200))
                .shouldHave(contentType(ContentType.JSON));

        assertions
                .assertBlogpostsServiceResponse(response)
                .shouldHaveBody_postBlogpost(blogpostId, updatedPayload.getUserId(), updatedPayload.getTitle(),
                        updatedPayload.getBody());
    }

    @Test
    void canDeleteBlogpost_expect_200() {
        response = blogpostService
                .deleteBlogpost(blogpostId)
                .shouldHave(statusCode(200));

        //TODO for the real API need I would:
        // 1) add precondition creating entity to be deleted
        // 2) after deletion send /get/posts/{id} request to check that the entity is no longer present in DB
    }
}
