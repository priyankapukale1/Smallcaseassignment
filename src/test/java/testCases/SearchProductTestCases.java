package testCases;

import annotation.Author;
import annotation.TestCaseNotes;
import org.testng.annotations.Test;
import testBase.TestBase;
import utils.Categories;
import utils.Properties;

import static annotation.TesterName.AKASH;

public class SearchProductTestCases extends TestBase {


    @Author(name = Priyanka)
    @TestCaseNotes(Steps = "go  to Flipkart.com || close the login pop-up || Search the vu tv|| ", expecatedResult = "tv should be display")
    @Test(groups = {Categories.SMOKE})
    public void searchProductAsGuestUser() {
        navigateTo(Properties.FLIPKART_BASE_URL);
        flipKartHomePage.closeLoginPopup();
        flipKartHomePage.searchProductSearchTextBox(Properties.PRODUCT_NAME);
        flipKartHomePage.clickOnFirstSearchProduct();
        flipKartHomePage.clickOnAddToCardButton();
        flipKartHomePage.updateProductQuantity();

    }


    @Author(name = Priyanka)
    @TestCaseNotes(Steps = "go  to amazon.in/  || Search the vu tv|| print the price || add to the card|| print the price ", expecatedResult = "tv should be display")
    @Test(groups = {Categories.SMOKE})
    public void searchProductOnAmazon() {
        navigateTo(Properties.AMAZON_BASE_URL);
        amazonHomePage.searchProductSearchTextBox(Properties.PRODUCT_NAME);
        amazonHomePage.clickOnFirstSearchProduct();
        amazonHomePage.clickOnAddToCardButton();
        amazonHomePage.updateProductQuantity();

    }


}
