package model.blogpostService;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import static utils.RandomDataUtil.randomInt;
import static utils.RandomDataUtil.randomString;


@Getter
@Setter
@SuperBuilder
public class PostBlogpostPayload {

    @JsonProperty("userId")
    @Builder.Default
    private int userId = randomInt(0, 10);

    @JsonProperty("title")
    @Builder.Default
    private String title = randomString(10);

    @JsonProperty("body")
    @Builder.Default
    private String body = randomString(10);

}