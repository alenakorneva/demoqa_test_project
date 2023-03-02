package elements;


import browser.BrowserUtils;
import org.openqa.selenium.By;
import utils.LogUtils;


public abstract class BaseElement {
    protected String name;
    protected By locator;

    public BaseElement(String name, By locator) {
        this.name = name;
        this.locator = locator;
    }

    public By getLocator() {
        return locator;
    }

    public void click() {
        BrowserUtils.findElementOnThePage(locator).click();
        LogUtils.setLogInfoForActionWithElement("Click ", name);
    }

    public String getText() {
        LogUtils.setLogInfoForActionWithElement("Get text of ", name);
        return BrowserUtils.findElementOnThePage(locator).getText();
    }
}
