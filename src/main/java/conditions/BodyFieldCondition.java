package conditions;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Matcher;


@RequiredArgsConstructor

public class BodyFieldCondition implements Condition {

    private final String path;
    private final Matcher matcher;

    public BodyFieldCondition(Matcher matcher) {
        this(null, matcher);
    }

    @Override
    public void check(Response response) {
        if (StringUtils.isBlank(path)){
            response.then().assertThat().body(matcher);
        } else {
            response.then().assertThat().body(path, matcher);
        }
    }
}
