package target;

import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.network.Network;

import java.util.Optional;

public class BlockNetworkRequests {
    public static void main(String[] args) {

        //css, images
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alioz\\Desktop\\drivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        //devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));

        long startTime = System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//app-root/app-landingpage/div/p[2]/a")).click();
        driver.findElement(By.xpath("//div/div[2]/div/ul/div[1]/li/div/div/a")).click();

        driver.findElement(By.xpath("//div[2]/div/div/div[2]/div[2]/button[1]")).click();
        System.out.println(driver.findElement(By.xpath("//app-product-shop/body/div[1]/p")).getText());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

    }

}
