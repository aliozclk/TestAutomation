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

        Thread.sleep(500);


        loginPage(driver);
        uncheckAllButtonTest(driver);
        System.out.println("-------------------------");
        driver.manage().window().maximize();

        //delete button
        loginPage(driver);
        deleteButtonTest(driver);
        System.out.println("------------------------");


        //edit button
        editButtonTest(driver);
        System.out.println("------------------");
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
        if (areAllButtonsSelected(driver)) {
            System.out.println("-Check All- Button Test :  -- Passed --");
        } else {
            System.out.println("-Check All- Button Test :  -- Fail --");
        }
    }

    public static boolean areAllButtonsSelected(WebDriver driver) {
        for (int i = 2; i < 10; i++) {
            String xPathOfCheckBox = "//*[@id=\"ctl00_MainContent_orderGrid_ctl0" + i + "_OrderSelector\"]";

            if (!driver.findElement(By.xpath(xPathOfCheckBox)).isSelected()) {
                return false;
            }
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
        if (areAllButtonsUnchecked(driver)) {
            System.out.println("-Uncheck All- Button Test : -- Passed");
        } else {
            System.out.println("-Uncheck All- Button Test : -- Fail ");
        }

    }

    public static boolean areAllButtonsUnchecked(WebDriver driver) {
        for (int i = 2; i < 10; i++) {
            String xPathOfCheckBox = "//*[@id=\"ctl00_MainContent_orderGrid_ctl0" + i + "_OrderSelector\"]";

            if (driver.findElement(By.xpath(xPathOfCheckBox)).isSelected()) {
                return false;
            }
        }

        return true;
    }

    public static void deleteButtonTest(WebDriver driver){
        //select a checkbox
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid_ctl02_OrderSelector\"]")).click();

        //get the name
        String nameOnDeletedLine = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[2]")).getText();

        //click delete button
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_btnDelete\"]")).click();
        //deleted name exists or not
        if(doesTheNameExist(driver,nameOnDeletedLine)){
            System.out.println("--Delete Button Test -- : -- Fail --");
        }
        else {
            System.out.println("--Delete Button Test -- : -- Passed --");
        }
    }

    public static boolean doesTheNameExist(WebDriver driver,String name){

        for (int i = 2; i < 9; i++) {

            String xpathOfName = "//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[" + i +  "]/td[2]";
            if(driver.findElement(By.xpath(xpathOfName)).getText().equals(name)){
                return true;
            }

        }

        return false;
    }

    public static void editButtonTest(WebDriver driver) throws InterruptedException {
        //get the name that is in the line
        String editedName = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[5]/td[2]")).getText();
        //click edit button
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[5]/td[13]/input")).click();
        Thread.sleep(2000);
        //check that name in this page
        String editPageName = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).getAttribute("value");

        if(editedName.equals(editPageName)){
            System.out.println("Edit Button Test : -- Passed --");
        }else {
            System.out.println("Edit Button Test : -- Fail --");
        }
    }

}
