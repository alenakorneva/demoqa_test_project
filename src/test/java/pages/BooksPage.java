package pages;

import browser.BrowserUtils;
import elements.Button;
import elements.Link;
import elements.TextElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

import java.util.ArrayList;
import java.util.List;

public class BooksPage extends BaseForm {

    private final Button loginButton = new Button("loginButton", By.id("login"));
    private final TextElement loggedInUserNameValue = new TextElement("loggedInUserNameValue", By.id("userName-value"));
    private final Link bookTitle = new Link("bookTitle", By.xpath("//div[contains(@class, 'action-buttons')]//a"));

    public void clickOnLoginButton() {
        WaitUtils.waitUntilWebElementIsClickable(loginButton.getLocator());
        loginButton.click();
    }

    public String getLoggedInUserNameTextValue() {
        WaitUtils.waitUntilWebElementIsClickable(loggedInUserNameValue.getLocator());
        return loggedInUserNameValue.getText();
    }

    public ArrayList<String> getListOfBooksNamesPresentedOnPage() {
        List<WebElement> listOfBooksNamesElements = BrowserUtils.getListOfElements(bookTitle.getLocator());
        ArrayList<String> listOfBooksNamesPresentedOnPage = new ArrayList<>();
        for (WebElement listOfBooksNamesElement : listOfBooksNamesElements) {
            listOfBooksNamesPresentedOnPage.add(listOfBooksNamesElement.getText());
        }
        return listOfBooksNamesPresentedOnPage;
    }
}
