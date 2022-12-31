package week_02.groupWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import static java.util.Collections.sort;


public class StandardUserZToAButtonTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/fkara/Downloads/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        ArrayList<String> products = new ArrayList<>();
        int size = driver.findElements(By.cssSelector(".inventory_item_name")).size();
        for (int i = 1; i < size; i++) {
            //get unordered products names from page
            String name = driver.findElements(By.cssSelector(".inventory_item_name")).get(i).getText();

            //assign these products in ArrayList
            products.add(name);
        }
        // sort A to Z
        sort(products);

        // sort Z to A
        for (int i = 0, j = products.size() - 1; i < j; i++, j--) {
            String temp = products.get(i);
            products.set(i, products.get(j));
            products.set(j, temp);
        }

        //select dropdown Z to A
        Select dropdown = new Select(driver.findElement(By.cssSelector("select[class='product_sort_container']")));
        dropdown.selectByIndex(1);


        //check them, sorted or not(Z to A)
        for (int i = 1; i < size; i++) {
            String actualName = driver.findElements(By.cssSelector(".inventory_item_name")).get(i - 1).getText();
            Assert.assertEquals(actualName, products.get(i - 1));
        }
        //driver.quit();
    }
}
