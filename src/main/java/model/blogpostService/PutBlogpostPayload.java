package model.blogpostService;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class PutBlogpostPayload extends PostBlogpostPayload {

    @JsonProperty("id")
    private int id;
}
