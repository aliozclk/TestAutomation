package week_02.groupWork;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class GenericMethodForCalendar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alioz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions");
        //April 23
        driver.findElement(By.xpath(".//*[@id='travel_date']")).click();


        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May")) {
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }


        List<WebElement> dates = driver.findElements(By.className("day"));
        //Grab common attribute//Put into list and iterate


        for (int i = 0; i < dates.size(); i++) {
            String text = driver.findElements(By.className("day")).get(i).getText();
            if (text.equalsIgnoreCase("21")) {
                driver.findElements(By.className("day")).get(i).click();
                break;
            }

        }
    }
}
