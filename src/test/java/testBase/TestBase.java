package testBase;

import driver.DriverInitializer;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    protected FlipKartHomePage flipKartHomePage;
    protected AmazonHomePage amazonHomePage;


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() throws Exception {
        driver = new DriverInitializer(System.getProperty("driver")).init();
        flipKartHomePage = new FlipKartHomePage();
        amazonHomePage = new AmazonHomePage();

        

    }

    protected void navigateTo(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    @AfterMethod(alwaysRun = true)
//    public void afterMethod(ITestResult result) {
//        if (null != driver) {
//            driver.quit();
//            driver = null;
//        }
//    }




}

