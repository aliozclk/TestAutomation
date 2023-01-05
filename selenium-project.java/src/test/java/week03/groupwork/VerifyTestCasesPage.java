package week03.groupwork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifyTestCasesPage {

    WebDriver driver;
    WebElement testCasesButton;

    //1. Launch browser
    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //2. Navigate to url 'http://automationexercise.com'
    @BeforeTest
    public void setUpTest() {

        //Launch Browser and Navigate to the URL
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

    }

    //3. Verify that home page is visible successfully
    @Test(priority = 1)
    public void verifyHomePageIsVisible(){
        String title = driver.getTitle();
        Assert.assertTrue(title.equalsIgnoreCase("Automation Exercise"));
    }

    //4. Click on 'Test Cases' button
    @Test(priority = 2)
    public void clickOnTestCasesButton(){
        testCasesButton = driver.findElement(By.xpath("//div[2]/div/ul/li[5]/a"));
        testCasesButton.click();

    }

    //5. Verify user is navigated to test cases page successfully
    @Test(priority = 3)
    public void verifyNavigationOfTestCasesPage(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"Automation Practice Website for UI Testing - Test Cases");
    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        driver.quit();
    }
}
