package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CLASSNAME_Locator {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        try{
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.get("file:///C:/MorningBatch_Combined/HTML/WebPage/WebApplication.html");
            Thread.sleep(2000);

            //Enter UserName and Password using className locator
            ch.findElement(By.className("frm1_un_class1")).sendKeys("adminnnn");
            ch.findElement(By.className("frm1_pwd_class1")).sendKeys("afafasfsafasfafaf");
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
