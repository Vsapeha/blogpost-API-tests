package services;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class ApiService {

    public RequestSpecification setUp() {
        return RestAssured.given()
                .filters(
//                        new AllureRestAssured(),
                        new RequestLoggingFilter(),
                        new ResponseLoggingFilter()
                );
    }
}
