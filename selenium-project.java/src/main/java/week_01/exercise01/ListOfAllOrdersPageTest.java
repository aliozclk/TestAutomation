package week_01.exercise01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListOfAllOrdersPageTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alioz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        loginPage(driver);
        checkAllButtonTest(driver);
        System.out.println("-----------------------");

        loginPage(driver);
        uncheckAllButtonTest(driver);
        System.out.println("-------------------------");



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

    public static void checkAllButtonTest(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_btnCheckAll\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_btnDelete\"]")).click();
        Thread.sleep(2000);

        String actual = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderMessage\"]")).getText();
        if (actual.equals("List of orders is empty. In order to add new order use this link.")) {
            System.out.println("Check All Button Test :  -- Passed --");
        } else {
            System.out.println("Check All Button Test :  -- Fail --");
        }
    }

    public static void uncheckAllButtonTest(WebDriver driver) throws InterruptedException {

        //Check All
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_btnCheckAll\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl02_OrderSelector\"]")).getAttribute("checked");
        Thread.sleep(2000);

        //Then uncheck All

    }
}
