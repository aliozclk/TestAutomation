package Automation_02.GroupWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class StandardUserDropdownAToZ {

    /* 1- Go to the website.
       2- Enter the correct username-for standard one, and the password.
       3- Select the 'A to Z' button.
       4- Check if the page is ordered properly or not.
       5- Quit the browser.
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Course Files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Select dropdown = new Select(driver.findElement(By.cssSelector("select[class='product_sort_container']")));
        dropdown.selectByVisibleText("Name (A to Z)");

        List<WebElement> names = driver.findElements(By.className("inventory_item_name"));
        ArrayList<String> nameList = new ArrayList<>();

        for (int i = 0; i < names.size(); i++) {
            nameList.add(names.get(i).getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        sortedList.addAll(nameList);
        java.util.Collections.sort(sortedList);

        try {
            for (int i = 0; i < nameList.size(); i++) {
                Assert.assertEquals(nameList.get(i), sortedList.get(i));
            }
            System.out.println("Ordered properly");
        } catch (AssertionError ex){
            System.out.println("Not ordered properly.");
        }

    }
}

