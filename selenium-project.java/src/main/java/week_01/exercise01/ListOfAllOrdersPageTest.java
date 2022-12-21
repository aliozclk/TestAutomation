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
        driver.quit();

        loginPage(driver);
        uncheckAllButtonTest(driver);
        System.out.println("-------------------------");
        driver.quit();





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

        Thread.sleep(500);
      if(areAllButtonsSelected(driver)){
            System.out.println("-Check All- Button Test :  -- Passed --");
        } else {
            System.out.println("-Check All- Button Test :  -- Fail --");
        }
    }

    public static boolean areAllButtonsSelected(WebDriver driver){
        if(!driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl02_OrderSelector\"]")).isSelected()){
            return false;
        }
        if(!driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl03_OrderSelector\"]")).isSelected()){
            return false;
        }
        if(!driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl04_OrderSelector\"]")).isSelected()){
            return false;
        }
        if(!driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl05_OrderSelector\"]")).isSelected()){
            return false;
        }
        if(!driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl06_OrderSelector\"]")).isSelected()){
            return false;
        }
        if(!driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl07_OrderSelector\"]")).isSelected()){
            return false;
        }
        if(!driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl08_OrderSelector\"]")).isSelected()){
            return false;
        }
        if(!driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl09_OrderSelector\"]")).isSelected()){
            return false;
        }
        return true;
    }


    public static void uncheckAllButtonTest(WebDriver driver) throws InterruptedException {

        //Check All
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_btnCheckAll\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl02_OrderSelector\"]")).getAttribute("checked");
        Thread.sleep(2000);

        //Then uncheck All
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_btnUncheckAll\"]")).click();
        if(areAllButtonsUnchecked(driver)){
            System.out.println("-Uncheck All- Button Test : -- Passed" );
        }
        else {
            System.out.println("-Uncheck All- Button Test : -- Fail ");
        }

    }

    public static boolean areAllButtonsUnchecked(WebDriver driver){
        if(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl02_OrderSelector\"]")).isSelected()){
            return false;
        }
        if(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl03_OrderSelector\"]")).isSelected()){
            return false;
        }
        if(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl04_OrderSelector\"]")).isSelected()){
            return false;
        }
        if(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl05_OrderSelector\"]")).isSelected()){
            return false;
        }
        if(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl06_OrderSelector\"]")).isSelected()){
            return false;
        }
        if(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl07_OrderSelector\"]")).isSelected()){
            return false;
        }
        if(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl08_OrderSelector\"]")).isSelected()){
            return false;
        }
        if(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl09_OrderSelector\"]")).isSelected()){
            return false;
        }
        return true;
    }

}
