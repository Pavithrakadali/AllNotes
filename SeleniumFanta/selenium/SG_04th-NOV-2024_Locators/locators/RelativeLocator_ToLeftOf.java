package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocator_ToLeftOf {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        String text = null;
        try{
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.get("file:///C:/MorningBatch_Combined/HTML/WebPage/WebApplication.html");
            Thread.sleep(2000);


            //Q: Identify the username which is located left side of password
            WebElement userName = ch.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(By.xpath("//input[@id='frm1_pwd_id1']")));
            userName.sendKeys("aaaaaaaaaaaaaaa");

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
