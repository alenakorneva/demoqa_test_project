package utils;

import io.restassured.response.ValidatableResponse;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class APIUtils {

    public static ValidatableResponse postRequest(String basePath, HashMap<String, ?> mapWithHeadersParams, HashMap<String, ?> mapWithBodyParams) {
        return given()
                .headers(mapWithHeadersParams)
                .body(mapWithBodyParams)
                .when()
                .post(basePath)
                .then()
                .log().all();
    }

    public static ValidatableResponse getRequest(String basePath) {
        return given()
                .when()
                .get(basePath)
                .then();
    }
}
