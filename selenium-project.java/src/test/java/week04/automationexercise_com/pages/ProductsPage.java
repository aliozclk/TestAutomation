package week04.automationexercise_com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage {

    @FindBy(xpath = "//*[@id=\"accordian\"]/div[1]/div[1]/h4/a")
    WebElement womenBtn;

    @FindBy(css = "[data-toggle = 'collapse']")
    public WebElement menBtn;

    @FindBy(css = "[data-toggle = 'collapse']")
    public WebElement kidsBtn;

    @FindBy(xpath = "//a[@href=\"/category_products/1\"]")
    public WebElement dressWmnBtn;

    @FindBy(xpath = "//a[@href=\"/category_products/2\"]")
    public WebElement topsWmnBtn;

    @FindBy(xpath = "//a[@href=\"/category_products/7\"]")
    public WebElement sareeWmnBtn;

    @FindBy(xpath = "//a[@href=\"/category_products/3\"]")
    public WebElement tshirtsMen;

    @FindBy(xpath = "//a[@href=\"/category_products/6\"]")
    public WebElement jeansMen;

    @FindBy(xpath = "//a[@href=\"/category_products/4\"]")
    public WebElement dressKids;

    @FindBy(xpath = "//a[@href=\"/category_products/5\"]")
    public WebElement topsKids;

    @FindBy(xpath = "//a[@href=\"/brand_products/Polo\"]")
    public WebElement polo;

    @FindBy(xpath = "//a[@href=\"/brand_products/H&M\"]")
    public WebElement hAndM;

    @FindBy(xpath = "//a[@href=\"/brand_products/Madame\"]")
    public WebElement madame;

    @FindBy(xpath = "//a[contains(@href, \"Harbour\")]")
    public WebElement mastHarbour;

    @FindBy(xpath = "//a[@href=\"/brand_products/Babyhug\"]")
    public WebElement babyhug;

    @FindBy(xpath = "//a[contains(@href, \"Solly\")]")
    public WebElement allenSollyJunior;

    @FindBy(xpath = "//a[@href=\"/brand_products/Kookie Kids\"]")
    public WebElement kookieKids;

    @FindBy(xpath = "//a[@href=\"/brand_products/Biba\"]")
    public WebElement biba;
    
    

}
