package pages;

import browser.BrowserUtils;
import elements.Button;
import elements.InputField;
import org.openqa.selenium.By;
import utils.JavaScriptUtils;
import utils.WaitUtils;

public class LoginPage extends BaseForm {

    private static final InputField userNameInputField = new InputField("userName", By.id("userName"));
    private static final InputField passwordInputField = new InputField("password", By.id("password"));
    private static final Button loginButton = new Button("loginButton", By.id("login"));

    public void insertUserName(String userName) {

        WaitUtils.waitUntilWebElementIsClickable(userNameInputField.getLocator());
        userNameInputField.fulfillInputArea(userName);
    }

    public void insertPassword(String password) {
        WaitUtils.waitUntilWebElementIsClickable(passwordInputField.getLocator());
        passwordInputField.fulfillInputArea(password);
    }

    public void clickLoginButton() {
        JavaScriptUtils.scrollUntilWebElementIsVisible(BrowserUtils.findElementOnThePage(loginButton.getLocator()));
        loginButton.click();
    }
}
