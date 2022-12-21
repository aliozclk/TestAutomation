package week_01.exercise01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPageTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\alioz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //TestCases For Login Page
        //-[0]-username and [1]- password

        String[][] loginInput = {{"Tester","test"},{"ali","test2"},{"emre","test3"}};
        String[] xPathOfRelatedElement = {"//*[@id=\"aspnetForm\"]/table/tbody/tr/td[2]/div[2]/h2","//*[@id=\"ctl00_MainContent_status\"]","//*[@id=\"ctl00_MainContent_status\"]"};
        String[] expectedResults = {"List of All Orders","Invalid Login or Password.","Invalid Login or Password."};

        for (int i = 0; i < loginInput.length; i++) {
            String username = loginInput[i][0];
            String password = loginInput[i][1];


            driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
            Thread.sleep(500);

            driver.findElement(By.xpath("//*[@id='ctl00_MainContent_username']")).sendKeys(username);
            driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_password\"]")).sendKeys(password);
            driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_login_button\"]")).click();

            Thread.sleep(2000);

            String actual = driver.findElement(By.xpath(xPathOfRelatedElement[i])).getText();
            String expected = expectedResults[i];

            if(actual.equals(expected)){
                System.out.println("Test " + (i+1) + " : " + "--Passed--" );
            }
            else {
                System.err.println("Test " + (i+1) + " : " + "-- Fail -- ");
            }

            System.out.println("--------------------");

        }

        driver.quit();


    }
}
