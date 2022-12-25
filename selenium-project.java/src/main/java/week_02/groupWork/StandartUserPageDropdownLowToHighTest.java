package week_02.groupWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class StandartUserPageDropdownLowToHighTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alioz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //login standart user
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        ArrayList<Double> prices = new ArrayList<>();

        for (int i = 1; i < 7; i++) {
            //get unordered prices form page
            String price = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div["+ i +"]/div[2]/div[2]/div")).getText();
            //trim $ sign from string
            String prc = price.substring(1);
            //assign these prices in ArrayList
            prices.add(Double.parseDouble(prc));
        }
        //sort list
        java.util.Collections.sort(prices);

        //select dropdown low to high price
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")));
        dropdown.selectByIndex(2);

        //check them, sorted or not
        for (int i = 1; i < 7; i++) {
            //get sorted prices from page
            String price = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div["+ i +"]/div[2]/div[2]/div")).getText();
            Assert.assertEquals(price,"$" + prices.get(i - 1));

        }

        driver.quit();

    }
}
