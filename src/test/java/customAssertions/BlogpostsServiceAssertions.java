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
//todo can 'data > badge objects> points'  be <=0???????
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

}
