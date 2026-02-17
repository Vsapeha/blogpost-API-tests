package conditions;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor

public class ContentTypeCondition implements Condition {

    private final ContentType expectedContentType;

    @Override
    public void check(Response response) {
        response.then().contentType(expectedContentType);
    }

    @Override
    public String toString() {
        return "Content Type " + expectedContentType;

    }
}
