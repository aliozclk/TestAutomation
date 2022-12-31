package homework_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LockedOutUser {
    public static void main(String[] args) {
        //TRY TO LOG IN AS locked_out_user AND PRINT THE ERROR THAT APPEARS ON THE SCREEN

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        //try login as a locked out user
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //print the error message on the screen
        String errorMessage = driver.findElement(By.xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']")).getText();
        System.out.println(errorMessage);

        driver.quit();
    }
}
