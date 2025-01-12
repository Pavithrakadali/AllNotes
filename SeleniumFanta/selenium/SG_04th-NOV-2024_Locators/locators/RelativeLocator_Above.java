package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocator_Above {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        String text = null;
        try{
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.get("file:///C:/MorningBatch_Combined/HTML/WebPage/WebApplication.html");
            Thread.sleep(2000);

            //Q: Identify the UserName by starting from OK button which is below userName
            WebElement UserName = ch.findElement(RelativeLocator.with(By.tagName("input")).above(By.xpath("//input[@id='frm1_ok_id1']")));
            UserName.sendKeys("asadsasas");

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
