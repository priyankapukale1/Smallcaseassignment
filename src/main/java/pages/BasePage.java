package pages;

import com.google.common.base.Preconditions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class BasePage {

    protected WebDriver driver;


    protected void waitForElementTobeClickable(WebElement webElement) {
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(webElement));
    }


    protected void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    protected void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    protected boolean waitForElementToBeDisplay(WebElement element) {
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(2));
        wait.until((Function<WebDriver, WebElement>) driver -> element);
        return element.isDisplayed();
    }

    public void waitTillVisibilityOfElement(By locator,  int second) {
        Preconditions.checkNotNull(locator, "Element to be checked for visibility cannot be null");
        new WebDriverWait(driver, second).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForListOfElementToBeDisplay(List<WebElement> element) {
        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(element)));
    }

    protected void waitForPageToLoad() {
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }


    public String getElementText(WebElement element) {
        String text = element.getText();
        return text;
    }
    public String getElementText(By locator) {
        String text = driver.findElement(locator).getText();
        return text;
    }


    protected void jsClick(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void typebyJsExecuter(WebElement locatorname, String keyword) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(String.format("document.getElementsByName('%s + ').value='%s'", locatorname, keyword));
    }

    public void typebyJsExecuter(By locatorname, String keyword) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(String.format("document.getElementsByName('%s + ').value='%s'", locatorname, keyword));
    }


    public void type(WebElement element, String keyword) {
        element.sendKeys(keyword);
    }

    public void clearText(WebElement element) {
        element.clear();
    }

    public void clearAndtype(By locator, String keyword) {
        By element = locator;
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(keyword);
    }

    protected void switchToActiveTab() {
        String parentWindow = driver.getWindowHandle();

        for (String childWindow : driver.getWindowHandles())
            if (!childWindow.equals(parentWindow))
                driver.switchTo().window(childWindow);
            else
                driver.close();
    }


    protected void switchToParentTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.switchTo().window(tabs.get(0));
        driver.switchTo().window(tabs.get(1));
    }

    public void openUrl(String url) {
        driver.navigate().to(url);

    }


}
