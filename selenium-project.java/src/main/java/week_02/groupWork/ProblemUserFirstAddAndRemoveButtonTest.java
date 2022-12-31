package Automation_02.GroupWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class ProblemUserFirstAddAndRemoveButtonTest {

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Course Files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // Go to the webpage
        driver.get("https://www.saucedemo.com/");

        // Login as problem user.
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Click the first item's 'ADD TO CART' button.
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Check the cart whether the item is added or not.
        driver.findElement(By.cssSelector("a.shopping_cart_link")).click();

        // Check the item's name ( if it is the same with the selected one ).
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText(),"Sauce Labs Backpack");

        // Click the 'CONTINUE SHOPPING' button.
        driver.findElement(By.id("continue-shopping")).click();

        // Check the first item's 'REMOVE' button.
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        // Check the number on the cart image to see if the item is removed or not.
        try{
            Assert.assertEquals(driver.findElement(By.cssSelector("span[class='shopping_cart_badge'")).getText(),"");
        }catch (AssertionError ex){
            System.out.println("'REMOVE' button bug");
        }
    }
}
