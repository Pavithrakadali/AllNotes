package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

public class FluentWaits {
    public static void main(String[] args) {
        WebDriver oBrowser = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("http://localhost/login.do");

            Wait<WebDriver> oWait = new FluentWait<WebDriver>(oBrowser)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class);
            oWait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            oBrowser = null;
        }
    }
}
