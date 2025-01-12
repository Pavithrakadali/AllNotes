package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocator_ToRightOf {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        String text = null;
        try{
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.get("file:///C:/MorningBatch_Combined/HTML/WebPage/WebApplication.html");
            Thread.sleep(2000);


            //Q: Identify the password which is located right side of username
            WebElement password = ch.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(By.xpath("//input[@id='frm1_un_id1']")));
            password.sendKeys("aaaaaaaaaaaaaaa");

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
