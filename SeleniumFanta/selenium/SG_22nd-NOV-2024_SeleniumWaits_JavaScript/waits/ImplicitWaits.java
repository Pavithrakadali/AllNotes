package waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWaits {
    public static void main(String[] args) {
        WebDriver oBrowser = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("http://localhost/login.do");

            oBrowser.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            oBrowser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            oBrowser.manage().timeouts().setScriptTimeout(Duration.ofSeconds(10));
            Thread.sleep(10);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            oBrowser = null;
        }
    }
}
