package week_01.exercise01;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class OrderPageTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alioz\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        //login to page
        loginPage(driver);


        //1-Product Dropdown Test
        productDropdownTest(driver);

        //2-Calculate Button Test
        calculateButtonTest(driver);

        //3-Address Info : With Missing Infos
        addressInfoBoxWithMissingLines(driver);


        //4-Give a string into the zip line
        invalidFormatInZipBoxTest(driver);


        //5-Give a string into the card number line
        invalidFormatInCardNumberBox(driver);

        //6-Invalid Card Date
        invalidCardDateTest(driver);

        //7-Process Button Test
        processButtonTest(driver);
        driver.quit();


    }

    public static void loginPage(WebDriver driver) throws InterruptedException {
        String username = "Tester";
        String password = "test";

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");

        driver.findElement(By.xpath("//*[@id='ctl00_MainContent_username']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_login_button\"]")).click();

    }

    public static void productDropdownTest(WebDriver driver) throws InterruptedException {
        boolean result = true;
        String[] prices = {"100", "80", "20"};

        //Order Page
        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();

        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_ddlProduct\"]")));
        //My Money -- 100
        String number = "";
        for (int i = 0; i < 3; i++) {
            dropdown.selectByIndex(i);
            number = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtUnitPrice\"]"))
                    .getAttribute("value");
            result = result && number.equals(prices[i]);
        }

        if (result) {
            System.out.println("Product Dropdown Test : -- Passed --");
        } else {
            System.out.println("Product Dropdown Test : -- Failed --");
            System.exit(1);
        }
    }

    public static void calculateButtonTest(WebDriver driver) throws InterruptedException {
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_ddlProduct\"]")));

        dropdown.selectByIndex(0);
        //MyMoney --> 100
        //Quantity --> 5
        //Total expected -->500

        //fill quantity box
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]")).sendKeys("5");
        //click on button
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/ol[1]/li[5]/input[2]")).click();
        //get total number and check
        Thread.sleep(500);
        String total = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtTotal\"]")).getAttribute("value");
        if (total.equals("500")) {
            System.out.println("Calculate Button Test : -- Passed --");
        } else {
            System.out.println("Calculate Button Test : -- Failed --");
            System.exit(1);
        }

    }

    public static void addressInfoBoxWithMissingLines(WebDriver driver) throws InterruptedException {
        //fill the quantity box
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]")).clear();
        WebElement quantityBox = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]"));
        quantityBox.sendKeys("5");

        //click on process to see warnings
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();


        //check warnings
        String warning = "";
        for (int i = 2; i < 6; i++) {
            warning = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_RequiredFieldValidator" + i + "\"]")).getText();
            if (warning.isEmpty()) {
                System.out.println("Address Information Warnings Test : -- Failed --");
                System.exit(1);
            }


        }
        System.out.println("Address Information Warnings Test : -- Passed --");

    }

    public static void invalidFormatInZipBoxTest(WebDriver driver) throws InterruptedException {
        //give a string in zip line
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]")).sendKeys("String");

        //click on process
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();



        //check that warning
        String warning = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_rev1\"]")).getText();
        if (warning.equals("Invalid format. Only digits allowed.")) {
            System.out.println("Invalid Format in Zip Box Test : -- Passed --");
        } else {
            System.out.println("Invalid Format in Zip Box Test : -- Failed --");
        }

    }

    private static void invalidFormatInCardNumberBox(WebDriver driver) throws InterruptedException {
        //give a string in card number box
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]")).sendKeys("string");
        //click on process
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();

        //check warning message
        String warning = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_RegularExpressionValidator2\"]")).getText();
        if (warning.equals("Invalid format. Only digits allowed.")) {
            System.out.println("Invalid Format Warning In Card Box Test : -- Passed --");
        } else {
            System.out.println("Invalid Format Warning In Card Box Test : -- Failed --");
        }

    }

    private static void invalidCardDateTest(WebDriver driver) throws InterruptedException {
        //the last month is 12th
        //so 12 is valid for month
        //try to give 13th
        //it must be invalid --> 13/24
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]")).sendKeys("13/24");
        //click on process button
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();


        //check : is there a warning?
        String warning = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_RegularExpressionValidator3\"]")).getText();
        if (warning.isEmpty()) {
            System.out.println("Invalid Expire Date (ex:13th month) :-- Failed --");
        } else {
            System.out.println("Invalid Expire Date (ex:13th month) :-- Passed --");
        }

    }

    private static void processButtonTest(WebDriver driver) throws InterruptedException {
        loginPage(driver);

        validInfoInputs(driver);

        //click on process
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]")).click();
        //go to view all orders page
        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[1]/a")).click();
        //check infos saved or not
        if (didInfosSaved(driver)) {
            System.out.println("Process Button Test : -- Passed --");
        } else {
            System.out.println("Process Button Test : -- Passed --");
        }

    }

    private static boolean didInfosSaved(WebDriver driver) {

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date currentDate = new Date();

        String[] infos = {"Customer Name", "MyMoney", "5", formatter.format(currentDate), "Street", "City",
                "MasterCard", "1234567891234567", "07/25"};

        boolean result = true;
        for (int i = 2; i < 13; i++) {
            String xPath = "//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[" + i + "]";
            String orderInfo = driver.findElement(By.xpath(xPath)).getText();
            result = result && infos[i].equals(orderInfo);
        }
        return result;

    }

    private static void validInfoInputs(WebDriver driver) {
        //click on order page
        driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
        //give quantity
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]")).sendKeys("5");

        //Address Infos
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).sendKeys("Customer Name");
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]")).sendKeys("Street");
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox3\"]")).sendKeys("City");
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]")).sendKeys("State");
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]")).sendKeys("12345");


        //click on card type
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_1\"]")).click();

        //give a card number
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]")).sendKeys("1234567891234567");
        //give expire date
        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]")).sendKeys("12/25");
    }
}
