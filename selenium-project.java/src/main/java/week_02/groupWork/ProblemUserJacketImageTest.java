package week_02.groupWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ProblemUserJacketImageTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alioz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //login problem user
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("problem_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        //click on image
        driver.findElement(By.xpath("//*[@id=\"item_5_img_link\"]/img")).click();

        //check image source on product page
        String imageSourceOnProductPage = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[1]/img")).getAttribute("src");

        Assert.assertTrue(imageSourceOnProductPage.contains("pullover"));

        driver.quit();


    }
}
