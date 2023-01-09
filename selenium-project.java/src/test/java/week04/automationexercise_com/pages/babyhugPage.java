package week04.automationexercise_com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class babyhugPage {

    @FindBy(xpath = "//li[@class='active']")
    WebElement activePageName;

    @FindBy(xpath = "//img[@src=\"/get_product_picture/11\"]")
    public WebElement img_1;

    @FindBy(xpath = "//img[@src=\"/get_product_picture/12\"]")
    public WebElement img_2;

    @FindBy(xpath = "//img[@src=\"/get_product_picture/15\"]")
    public WebElement img_3;

    @FindBy(xpath = "//img[@src=\"/get_product_picture/16\"]")
    public WebElement img_4;
    
    
}
