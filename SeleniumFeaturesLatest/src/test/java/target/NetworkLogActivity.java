package target;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.network.Network;
import org.openqa.selenium.devtools.v108.network.model.Request;
import org.openqa.selenium.devtools.v108.network.model.Response;


import java.util.Optional;

public class NetworkLogActivity {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\alioz\\Desktop\\drivers\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();


        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), requestWillBeSent ->
        {
            Request req = requestWillBeSent.getRequest();
            System.out.println(req.getUrl());
            //req.getHeaders()
        });

        //Event will get fired-
        devTools.addListener(Network.responseReceived(), responseReceived ->
        {
            Response response = responseReceived.getResponse();
            //System.out.println(response.getUrl());
            //System.out.println(response.getStatus());
            if(response.getStatus().toString().startsWith("4")){
                System.out.println(response.getUrl()+ " is failing with status code " + response.getStatus());
            }
        }
        );

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("/html/body/app-root/app-landingpage/div/button")).click();


    }
}
