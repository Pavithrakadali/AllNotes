package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssSelector_Locator {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        String text = null;
        try{
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.get("file:C:/Notes/SeleniumFanta/DemoUIs/WebApplication.html");
            Thread.sleep(2000);

            //Enter first username using absolute cssSelector
            ch.findElement(By.cssSelector("input[id='frm1_un_id1']")).click();

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
