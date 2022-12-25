package week_02.groupWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class StandardUserPageLOgOutButton {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alioz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);




        //login with true infos
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //click on menu button
        driver.findElement(By.id("react-burger-menu-btn")).click();

        //click on logout button
        driver.findElement(By.id("logout_sidebar_link")).click();

        //this button must navigate to the home page :"https://www.saucedemo.com/"
        String url = driver.getCurrentUrl();

        Assert.assertEquals(url,"https://www.saucedemo.com/");

        driver.quit();

    }
}
