package week_03.groupWork;

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

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginWithIncorrectEmailAndPassword {

    WebDriver driver;
    WebElement logInPageButton;
    WebElement emailBox;
    WebElement passwordBox;
    WebElement loginButton;

    @BeforeSuite
    public void setUpSuite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeTest
    public void setUpTest() {

        //Launch Browser and Navigate to the URL
        driver.get("https://automationexercise.com/");

    }

    @Test(priority = 1)
    public void verifyHomePageIsVisible(){
        String title = driver.getTitle();
        Assert.assertTrue(title.equalsIgnoreCase("Automation Exercise"));
    }

    @Test(priority = 2)
    public void verifySignUpLoginPage(){
        //click on signup/login button
        logInPageButton = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        logInPageButton.click();
        //get title and check
        String title = driver.getTitle();
        Assert.assertTrue(title.equalsIgnoreCase("Automation Exercise - Signup / Login"));

    }

    @Test(priority = 3)
    public void verifyLoginText(){
        String text = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).getText();

        Assert.assertEquals(text,"Login to your account");
    }

    @Test(priority = 4)
    public void loginWithIncorrectEmailAndPassword(){
        emailBox = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailBox.sendKeys("wrongemail@email.com");
        passwordBox = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passwordBox.sendKeys("wrongpassword");
        loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginButton.click();

    }

    @Test(priority = 5)
    public void verifyErrorMessage() throws InterruptedException {
        Thread.sleep(2000);
        String error = driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']")).getText();
        Assert.assertEquals(error,"Your email or password is incorrect!");
    }

    @AfterSuite
    public void afterTest() {
        // Perform cleanup tasks or generate test reports here
        driver.quit();
    }




}
