package requests;

import APIModels.Books;
import APIModels.User;
import io.restassured.RestAssured;
import service.TestDataReaderFromConfigFile;
import utils.APIUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class APIApplicationRequest {
    private static final String USER_NAME = "userName";
    private static final String PASSWORD = "password";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String BASE_URL = TestDataReaderFromConfigFile.getStringValueFromJsonByKey("baseURLForAPIRequests");


    public static User getUserCredentials() {
        RestAssured.baseURI = BASE_URL;
        HashMap<String, String> headersParams = new HashMap<>() {{
            put(CONTENT_TYPE, TestDataReaderFromConfigFile.getStringValueFromJsonByKey("contentType"));
        }};

        HashMap<String, String> queryParams = new HashMap<>() {{
            put(USER_NAME, TestDataReaderFromConfigFile.getStringValueFromJsonByKey(USER_NAME));
            put(PASSWORD, TestDataReaderFromConfigFile.getStringValueFromJsonByKey(PASSWORD));
        }};
        return APIUtils.postRequest(TestDataReaderFromConfigFile.getStringValueFromJsonByKey("pathToCreateUserCredentials"), headersParams, queryParams).extract().as(User.class);
    }

    public static ArrayList<String> getBooksTitles() {
        ArrayList<String> booksTitles = new ArrayList<>();
        RestAssured.baseURI = BASE_URL;
        Books books = APIUtils.getRequest(TestDataReaderFromConfigFile.getStringValueFromJsonByKey("pathToGetListOfBooks")).extract().as(Books.class);
        for (int i = 0; i < books.getBooks().length; i++) {
            booksTitles.add(books.getBooks()[i].getTitle());
        }
        return booksTitles;
    }
}
