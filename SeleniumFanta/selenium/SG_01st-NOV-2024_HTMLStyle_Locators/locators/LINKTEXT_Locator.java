package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LINKTEXT_Locator {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        try{
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.get("file:///C:/MorningBatch_Combined/HTML/WebPage/WebApplication.html");
            Thread.sleep(2000);

            //click the link using linkText locator
            ch.findElement(By.linkText("Facebook")).click();
            Thread.sleep(5000);
            ch.navigate().back();
            Thread.sleep(5000);
            ch.findElement(By.linkText("ActiTime")).click();
            Thread.sleep(5000);
            ch.navigate().back();

            Thread.sleep(4000);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            ch.close();
            ch = null;
        }
    }
}
