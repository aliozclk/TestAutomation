package target;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SetGeoLocation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alioz\\Desktop\\drivers\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        //40 3

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        Map<String, Object> coordinates = new HashMap<>();
        coordinates.put("latitude",40);
        coordinates.put("longitude",3);
        coordinates.put("accuracy",1);

        driver.executeCdpCommand("Emulation.setGeolocationOverride",coordinates);

        driver.get("https://www.google.com");
        driver.findElement(By.className("gLFyf")).sendKeys("netflix", Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/a/h3")).click();

        String title = driver.findElement(By.className("our-story-card-title")).getText();
        System.out.println(title);

    }

}
