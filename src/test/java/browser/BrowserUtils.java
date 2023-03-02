package browser;


import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrowserUtils {

    public static void openPage(String url) {
        DriverSingleton.getDriver().get(url);
    }

    public static void maximizeWindow() {
        DriverSingleton.getDriver().manage().window().maximize();
    }

    public static WebElement findElementOnThePage(By locator) {
        return DriverSingleton.getDriver().findElement(locator);
    }

    public static List<WebElement> getListOfElements(By locator) {
        return DriverSingleton.getDriver().findElements(locator);
    }

}
