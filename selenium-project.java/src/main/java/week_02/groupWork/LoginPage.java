package week_02.groupWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alioz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);




        //login with true infos
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");

        //fake users
        String[][] loginInfos = {{"fatih","kara"},{"furkan","sener"},{"ali","özçelik"}};
        for (int i = 0; i < 3; i++) {
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys(loginInfos[i][0]);
            driver.findElement(By.id("password")).sendKeys(loginInfos[i][1]);
            driver.findElement(By.id("login-button")).click();


            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText(),
                    "Epic sadface: Username and password do not match any user in this service");
        }

        driver.quit();



    }
}
