package responses.blogpostsService;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetListOfBlogpostsResponse {

	private List<Blogpost> blogposts;

}