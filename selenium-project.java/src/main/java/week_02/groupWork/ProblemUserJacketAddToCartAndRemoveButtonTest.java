package week_02.groupWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ProblemUserJacketAddToCartAndRemoveButtonTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alioz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //login problem user
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //click on add to cart id = add-to-cart-sauce-labs-fleece-jacket
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();

        //get text on button
        String textOnButton = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).getText();

        //TEXT must be "REMOVE"
        Assert.assertEquals(textOnButton,"REMOVE");

        //if execution continues check REMOVE button

        //click on REMOVE button
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();

        //get text on button
        textOnButton = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).getText();

        //text must be "ADD TO CART"
        Assert.assertEquals(textOnButton,"ADD TO CART");


        driver.quit();
    }
}
