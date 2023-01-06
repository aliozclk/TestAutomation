package week03.groupwork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterBeforeCheckoutTest {

    WebDriver driver;
    WebElement logInPageButton;

    @BeforeSuite
    public void setUpSuite() {
        //allow insecure certs
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    //1. Launch browser
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

    //4. Click 'Signup / Login' button
    @Test(priority = 2)
    public void verifySignUpLoginPage(){
        //click on signup/login button
        logInPageButton = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        logInPageButton.click();
        //get title and check
        String title = driver.getTitle();
        Assert.assertTrue(title.equalsIgnoreCase("Automation Exercise - Signup / Login"));

    }

    //5. Fill all details in Signup and create account
    @Test(priority = 3)
    public void createAccount(){
        WebElement name = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        name.sendKeys("Name Surname");
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("name@email.com");
        WebElement signupButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        signupButton.click();

        WebElement passwordBox = driver.findElement(By.id("password"));
        passwordBox.sendKeys("password");

        WebElement firstNameBox = driver.findElement(By.id("first_name"));
        WebElement lastNameBox = driver.findElement(By.id("last_name"));
        firstNameBox.sendKeys("FirstName");
        lastNameBox.sendKeys("LastName");

        Select dropdown = new Select(driver.findElement(By.id("country")));
        String country = "United States";
        dropdown.deselectByVisibleText(country);

        WebElement addressBox = driver.findElement(By.id("address1"));
        WebElement stateBox = driver.findElement(By.id("state"));
        WebElement cityBox = driver.findElement(By.id("city"));
        WebElement zipcodeBox = driver.findElement(By.id("zipcode"));
        WebElement numberBox = driver.findElement(By.id("mobile_number"));

        addressBox.sendKeys("1.st Street,2nd Block,Apple");
        stateBox.sendKeys("Texas");
        cityBox.sendKeys("Dallas");
        zipcodeBox.sendKeys("123456");
        numberBox.sendKeys("123456789");

        WebElement createAccountBtn = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        createAccountBtn.click();

    }
    //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    @Test(priority = 4)
    public void verifyAccountCreatedMessageAndContinue(){
        String message = driver.findElement(By.xpath("//div/h2/b")).getText();
        Assert.assertTrue(message.equalsIgnoreCase("ACCOUNT CREATED!"));

        WebElement continueBtn = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        continueBtn.click();


    }







}
