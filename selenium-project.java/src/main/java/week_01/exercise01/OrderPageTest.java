package week_01.exercise01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrderPageTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\alioz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //login to page
        loginPage(driver);
        productDropdownTest(driver);
        driver.quit();

        //Product Dropdown Test

        //Calculate Button Test

        //Address Info Without City

        //Give a string into the zip line

        //Give a string into the card number line

        //Process Button Test

        //Reset Button Test
    }
    public static void loginPage(WebDriver driver) throws InterruptedException {
        String username = "Tester";
        String password = "test";

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_username']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_login_button\"]")).click();

        Thread.sleep(2000);
    }

    public static void productDropdownTest(WebDriver driver) throws InterruptedException {
        boolean result = true;
        String[] prices = {"100","80","20"};

        //Order Page
        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
        Thread.sleep(500);

        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_ddlProduct\"]")));
        //My Money -- 100
        String number = "";
        for (int i = 0; i < 3; i++) {
            dropdown.selectByIndex(i);
            number = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtUnitPrice\"]")).getAttribute("value");
            result = result && number.equals(prices[i])  ;
            Thread.sleep(1000);
        }

        if (result){
            System.out.println("Product Dropdown Test : -- Passed --");
        }
        else {
            System.out.println("Product Dropdown Test : -- Fail --");
        }
    }
}
