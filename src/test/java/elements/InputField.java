package elements;


import browser.BrowserUtils;
import org.openqa.selenium.By;
import utils.LogUtils;

public class InputField extends BaseElement {

    public InputField(String name, By locator) {
        super(name, locator);
    }

    public void fulfillInputArea(String textToFulfill) {
        LogUtils.setLogInfoForActionWithElement("Insert text " + textToFulfill + " in ", name);
        BrowserUtils.findElementOnThePage(locator).sendKeys(textToFulfill);
    }
}
