package target;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.fetch.Fetch;
import org.openqa.selenium.devtools.v108.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v108.network.model.ErrorReason;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class NetworkFailedRequest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alioz\\Desktop\\drivers\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();


        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        //java.util.Optional<java.lang.String> urlPattern
        Optional<List<RequestPattern>> patterns = Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty())));
        devTools.send(Fetch.enable(patterns,Optional.empty()));

        devTools.addListener(Fetch.requestPaused(),request ->
        {
            devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Library")).click();


    }
}
