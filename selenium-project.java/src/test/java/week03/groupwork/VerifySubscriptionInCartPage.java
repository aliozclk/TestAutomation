package week03.groupwork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class VerifySubscriptionInCartPage {
    WebDriver driver;
    WebElement cartButton;

    //1. Launch browser
    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
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
    public void clickOnCartButton(){
        cartButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a"));
        cartButton.click();
        ////li[3]/a[@xpath='1']
    }

    //5. Scroll down to footer and
    //6. Verify text 'SUBSCRIPTION'
    @Test(priority = 3)
    public void verifySubscription(){
        //scroll down 500
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        String text = driver.findElement(By.xpath("//div[@class='single-widget']/h2")).getText();
        Assert.assertTrue(text.equalsIgnoreCase("Subscription"));
    }

    //7. Enter email address in input and click arrow button
    @Test(priority = 4)
    public void enterEmailAndClickArrowButton(){
        driver.findElement(By.id("susbscribe_email")).sendKeys("myname@mail.com");
        driver.findElement(By.xpath("//form/button/i")).click();

    }

    //8. Verify success message 'You have been successfully subscribed!' is visible
    @Test(priority = 5)
    public void verifySuccessMessage(){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='alert-success alert']"))));

        String message = driver.findElement(By.xpath("//div[@class='alert-success alert']")).getText();
        Assert.assertTrue(message.equalsIgnoreCase("You have been successfully subscribed!"));

    }
    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        driver.quit();
    }
}
