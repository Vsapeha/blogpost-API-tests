package customAssertions;

import assertions.AssertableResponse;
import responses.blogpostsService.Blogpost;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.stream.Collectors;


public class BlogpostsServiceAssertions extends AbstractAssert<BlogpostsServiceAssertions, AssertableResponse> {
    public BlogpostsServiceAssertions(AssertableResponse actual) {
        super(actual, BlogpostsServiceAssertions.class);
    }

    public void shouldHaveBody_getListOfBlogposts() {
        List<Blogpost> responseAsPojo = actual.asPojoList(Blogpost.class);

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions
                .assertThat(responseAsPojo.stream().map(Blogpost::getUserId).collect(Collectors.toList()))
                .as("blogposts user ids")
                .doesNotContainNull()
                .noneMatch(id -> id <= 0);
        softAssertions
                .assertThat(responseAsPojo.stream().map(Blogpost::getId).collect(Collectors.toList()))
                .as("blogposts ids")
                .doesNotContainNull()
                .noneMatch(id -> id <= 0);
        softAssertions
                .assertThat(responseAsPojo.stream().map(Blogpost::getTitle).collect(Collectors.toList()))
                .as("blogposts titles")
                .doesNotContainNull()
                .noneMatch(String::isEmpty);
        softAssertions
                .assertThat(responseAsPojo.stream().map(Blogpost::getBody).collect(Collectors.toList()))
                .as("blogposts bodies")
                .doesNotContainNull()
                .noneMatch(String::isEmpty);

        softAssertions.assertAll();

    }


    public void shouldHaveBody_postBlogpost(int userId, String expectedTitle, String expectedBody) {
        Blogpost responseAsPojo = actual.asPojo(Blogpost.class);

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions
                .assertThat(responseAsPojo.getId())
                .as("id")
                .isNotNull();
        softAssertions
                .assertThat(responseAsPojo.getUserId())
                .as("userId")
                .isEqualTo(userId);
        softAssertions
                .assertThat(responseAsPojo.getTitle())
                .as("title")
                .isEqualTo(expectedTitle);
        softAssertions
                .assertThat(responseAsPojo.getBody())
                .as("body")
                .isEqualTo(expectedBody);

        softAssertions.assertAll();

    }

    public void shouldHaveBody_postBlogpost(int id, int userId, String expectedTitle, String expectedBody) {
        Blogpost responseAsPojo = actual.asPojo(Blogpost.class);

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions
                .assertThat(responseAsPojo.getId())
                .as("id")
                .isEqualTo(id);
        softAssertions
                .assertThat(responseAsPojo.getUserId())
                .as("userId")
                .isEqualTo(userId);
        softAssertions
                .assertThat(responseAsPojo.getTitle())
                .as("title")
                .isEqualTo(expectedTitle);
        softAssertions
                .assertThat(responseAsPojo.getBody())
                .as("body")
                .isEqualTo(expectedBody);

        softAssertions.assertAll();

    }
}
