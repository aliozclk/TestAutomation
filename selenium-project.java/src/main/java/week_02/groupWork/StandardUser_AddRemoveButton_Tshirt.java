package homework_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StandardUser_AddRemoveButton_Tshirt {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        //log in as a standard user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //check the ADD TO CART button
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[6]/div[2]/div[2]/button")).click();
        String remove = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[6]/div[2]/div[2]/button")).getText();
        if (remove != "Remove") {
            System.out.println("ADD TO CART button works successfully");
        } else {
            System.out.println("ADD TO CART button doesn't work");
        }

        Thread.sleep(4000);
        //check the REMOVE button
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[6]/div[2]/div[2]/button")).click();
        String add = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[6]/div[2]/div[2]/button")).getText();
        if (add != "Add to cart") {
            System.out.println("REMOVE button works succesfully");
        } else {
            System.out.println("REMOVE button doesn't work");
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
