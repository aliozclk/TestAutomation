package week_02.groupWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;

public class Dropdown_HighToLow {
    public static void main(String[] args) {
        //SORTING THE PRICES ON THE www.saucedemo.com WEBSITE USING THE HIGH TO LOW FEATURE AND CHECKING THIS FEATURE

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        //Login as a standard user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //select high to low price
        WebElement staticDropdown = driver.findElement(By.className("product_sort_container"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);

        //sort list
        ArrayList<Double> prices = new ArrayList<>();

        //get prices from page
        for (int i = 1; i < 7; i++) {
            String price = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")).getText();
            String prc = price.substring(1);
            prices.add(Double.parseDouble(prc));
        }
        java.util.Collections.sort(prices);
        //checking for sorted or not
        for (int i = 1; i < 7; i++) {
            String price = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")).getText();
            Assert.assertEquals(price, "$" + prices.get(i - 1));
        }
        driver.quit();


    }
}
