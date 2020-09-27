package pages;

import driver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKartHomePage extends BasePage {

    @FindBy(name = "q")
    WebElement productSearchTextBox;
    @FindBy(className = "_29YdH8")
    WebElement closeLoginPopup;

    @FindBy(className = "vh79eN")
    WebElement searchButton;

    @FindBy(className = "_3wU53n")
    WebElement productList;

    @FindBy(xpath = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
    WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='_1vC4OE _3qQ9m1']")
    WebElement productPrice;

    public static final By productQuantity = By.xpath("//div[@class='_2zH4zg']/input[@class='_2csFM9' and 1]");
    public static final By productPrice_CartPage = By.xpath("//div[@class='_3xFQAD']/div[@class='hJYgKM' and 1]");


    public FlipKartHomePage() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }


    public void searchProductSearchTextBox(String searchProductName) {
        waitForElementToBeDisplay(productSearchTextBox);
        productSearchTextBox.sendKeys(searchProductName);
        clickSearch();
    }

    public void clickSearch() {
        waitForElementToBeDisplay(searchButton);
        jsClick(searchButton);

    }

    public void closeLoginPopup() {
        waitForElementToBeDisplay(closeLoginPopup);
        jsClick(closeLoginPopup);

    }

    public void clickOnFirstSearchProduct() {
        waitForElementToBeDisplay(productList);
        jsClick(productList);
        switchToActiveTab();
        waitForElementToBeDisplay(productPrice);
        System.out.println(getElementText(productPrice));

    }

    public void clickOnAddToCardButton() {
        waitForElementTobeClickable(addToCartButton);
        addToCartButton.click();
    }

    public void updateProductQuantity() {
        waitTillVisibilityOfElement(productPrice_CartPage, 10);
        clearAndtype(productQuantity, "2");
        waitTillVisibilityOfElement(productPrice_CartPage, 10);
        printItemPrice(productPrice_CartPage);

    }

    public void printItemPrice(By locator) {
        System.out.println(getElementText(locator));
    }

}
