package week03.groupwork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.*;

public class BrandNamesOnProductsPageTest {
    WebDriver driver;
    String randomBrandName;


    @BeforeSuite
    public void setUpSuite() {
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\alioz\\Downloads\\extension_3_15_2_0.crx"));


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    @BeforeTest
    public void setUpTest() {

        //Launch Browser and Navigate to the URL
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindow = it.next();
        driver.switchTo().window(parentWindow);

    }

    //3. Click on 'Products' button
    @Test(priority = 1)
    public void clickOnProductsButton(){
        WebElement productsBtn = driver.findElement(By.xpath("//li/a[@href='/products']"));
        productsBtn.click();

    }

    //4. Verify that Brands are visible on left side bar
    @Test(priority = 2)
    public void verifyBrandsAreVisibleOnTheLeft(){
        //scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        List<WebElement> brandNames = driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-stacked']/li"));
        int countOfBlankAreas =(int) brandNames.stream().filter(brand -> brand.getText().isEmpty()).count();
        Assert.assertTrue(countOfBlankAreas == 0 );
    }

    //5. Click on any brand name
    @Test(priority = 3)
    public void clickOnAnyBrandName(){
        List<WebElement> brandNames = driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-stacked']/li"));

        int randomBrandIndex = (new Random().nextInt(brandNames.size()));
        WebElement randomBrand = brandNames.get(randomBrandIndex);
        randomBrandName = randomBrand.getText();
        randomBrand.click();
    }
    //8. Verify that user is navigated to that brand page and can see products
    @Test(priority = 4)
    public void VerifyBrandPageAndProductsAreVisible(){
        String titleOfProduct = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        System.out.println(titleOfProduct + " " + randomBrandName);
        System.out.println(titleOfProduct.contains(randomBrandName));
        Assert.assertTrue(titleOfProduct.contains(randomBrandName));

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='col-sm-4']"));
        int numberOfProductImg = (int)products.stream().filter(prod -> prod.findElement(By.xpath("//div[@class='productinfo text-center']/img")).isDisplayed()).count();

        Assert.assertTrue(numberOfProductImg != 0);
    }


}
