package assertions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import conditions.Condition;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class AssertableResponse {

    private final Response response;

    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }

    public <T> T asPojo(Class<T> tClass) {
        String responseBody = response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(responseBody, tClass);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public <T> List<T> asPojoList(Class<T> tClass) {
        String responseBody = response.getBody().asString();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, tClass);
            return objectMapper.readValue(responseBody, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
