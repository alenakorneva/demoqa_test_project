package test;

import APIModels.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BooksPage;
import pages.LoginPage;
import requests.APIApplicationRequest;
import service.TestDataReaderFromConfigFile;
import utils.LogUtils;

public class DemoQATest extends CommonTestConditions {
    BooksPage booksPage = new BooksPage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "Test login functionality")
    public void loginTest() {

        LogUtils.setLogInfoForStep(2, "Click login button");
        booksPage.clickOnLoginButton();
        LogUtils.setLogInfoForStep(3, "Create new user using API");
        User testUser = APIApplicationRequest.getUserCredentials();
        LogUtils.setLogInfoForStep(3, "Login with correct user credentials");
        loginPage.insertUserName(testUser.getUsername());
        loginPage.insertPassword(TestDataReaderFromConfigFile.getStringValueFromJsonByKey("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(booksPage.getLoggedInUserNameTextValue(), TestDataReaderFromConfigFile.getStringValueFromJsonByKey("userName"),
                "Logged in user name isn't similar to the one inserted into login form.");
    }

    @Test(description = "Compare books list from API response and UI")
    public void compareListOfBooks() {
        LogUtils.setLogInfoForStep(2, "Compare books titles presented on the page with books titles from the API response");
        Assert.assertEquals(booksPage.getListOfBooksNamesPresentedOnPage(), APIApplicationRequest.getBooksTitles(),
                "Books titles presented on the page aren't similar to the titles from the API response");
    }
}
