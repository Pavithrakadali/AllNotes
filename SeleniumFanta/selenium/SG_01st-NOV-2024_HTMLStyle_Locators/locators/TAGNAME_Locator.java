package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TAGNAME_Locator {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        try{
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.get("file:///C:/MorningBatch_Combined/HTML/WebPage/WebApplication.html");
            Thread.sleep(2000);

            //Enter UserName and Password using tagName locator
            ch.findElement(By.tagName("input")).sendKeys("adminnnn");
            ch.findElement(By.tagName("a")).click();
            Thread.sleep(4000);

        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            ch.quit();
            ch = null;
        }
    }
}
