package customAssertions;

import assertions.AssertableResponse;

public class HardAssertionEntryPoint {


    public HardAssertionEntryPoint() {
    }

    public BlogpostsServiceAssertions assertBlogpostsServiceResponse(AssertableResponse actual) {
        return new BlogpostsServiceAssertions(actual);
    }
}

