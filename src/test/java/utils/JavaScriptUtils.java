package utils;


import driver.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {
    public static void scrollUntilWebElementIsVisible(WebElement webElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverSingleton.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }
}
