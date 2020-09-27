package pages;

import driver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AmazonHomePage extends BasePage {
    public static final String ASIN = "B07XMD275S";


    @FindBy(xpath = "//input[@name='field-keywords']")
    WebElement productSearchTextBox;

    @FindBy(xpath = "//input[@value='Go']")
    WebElement searchButton;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    WebElement productList;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCartButton;

    @FindBy(xpath = "//span[@id='priceblock_ourprice']")
    WebElement productPrice;

    @FindBy(xpath = "//a[@id='hlb-view-cart-announce']")
    WebElement cardButton;

    public static final By productPrice_CartPage = By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']");
    // public static final By cardButton = By.xpath("//a[@id='hlb-view-cart-announce']");


    public AmazonHomePage() {
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
        waitForElementTobeClickable(cardButton);
        cardButton.click();


    }

    public void updateProductQuantity() {
        waitTillVisibilityOfElement(productPrice_CartPage, 10);
        waitTillVisibilityOfElement(productPrice_CartPage, 10);
        printItemPrice(productPrice_CartPage);

    }

    public void printItemPrice(By locator) {
        System.out.println(getElementText(locator));
    }


//    public void clickOnAddToCartButton() {
//        scrollToElement(DetailPage.ADDTO_CART_BUTTON, testContext);
//        waitHere(SystemConstants.EXTENDED_TIMEOUT_IN_SECONDS);
//        click(DetailPage.ADDTO_CART_BUTTON, testContext);
//    }
}
