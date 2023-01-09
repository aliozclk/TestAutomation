package week04.automationexercise_com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")
    WebElement homeButton;

    @FindBy(xpath = "//a[@href=\"/products\"]")
    public WebElement productsBtn;

    @FindBy(xpath = "/html/body/header/div/div/div/div[2]/div/ul/li[3]/a")
    public WebElement cartButton;

    @FindBy(xpath = "//a[@href=\"/login\"]")
    public WebElement signupLoginBtn;

    @FindBy(xpath = "/html/body/header/div/div/div/div[2]/div/ul/li[5]/a")
    public WebElement testCasesBtn;

    @FindBy(xpath = "/html/body/header/div/div/div/div[2]/div/ul/li[6]/a")
    public WebElement apiTestingBtn;

    @FindBy(xpath = "//a[contains(@href, \"www\")]")
    public WebElement videoTutorialsBtn;

    @FindBy(xpath = "//a[@href=\"/contact_us\"]")
    public WebElement contactBtn;

    @FindBy(xpath = "//a[@href=\"/category_products/1\"]")
    public WebElement dressWomenBtn;

    @FindBy(xpath = "//li[.//a[@href=\"/category_products/2\"]]")
    public WebElement topsWomenBtn;

    @FindBy(xpath = "//li[.//a[@href=\"/category_products/7\"]]")
    public WebElement sareeWomenBtn;

    @FindBy(xpath = "/html/body/section[2]/div/div[1]/div[1]/div/div[1]/div[2]/div[1]/h4/a/span")
    public WebElement menBtn;

    @FindBy(xpath = "//a[@href=\"/category_products/3\"]")
    public WebElement menTshirtsBtn;

    @FindBy(xpath = "//a[@href=\"/category_products/6\"]")
    public WebElement menJeansBtn;

    @FindBy(xpath = "/html/body/section[2]/div/div[1]/div[1]/div/div[1]/div[3]/div[1]/h4/a/span")
    public WebElement element;

    @FindBy(xpath = "/html/body/section[2]/div/div[1]/div[1]/div/div[1]/div[3]/div[1]/h4/a/span")
    public WebElement kidsBtn;

    @FindBy(xpath = "//a[@href=\"/category_products/4\"]")
    public WebElement dressKidsBtn;

    @FindBy(xpath = "//a[@href=\"/category_products/5\"]")
    public WebElement topsKidsBtn;
       


}
