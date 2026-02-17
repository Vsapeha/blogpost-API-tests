package conditions;

import io.restassured.http.ContentType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Conditions {

    public static StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }

    public static ContentTypeCondition contentType(ContentType contentType) {
        return new ContentTypeCondition(contentType);
    }
}
