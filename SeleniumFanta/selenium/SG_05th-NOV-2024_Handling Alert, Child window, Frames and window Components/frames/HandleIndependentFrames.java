package frames;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleIndependentFrames {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        String sParent = null;
        try {
            //1. Open browser and navigate the URL
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.navigate().to("file:///C:/MorningBatch_Combined/HTML/iFrames/Independent/IndependentFrameApp.html");
            Thread.sleep(2000);

            //2. Read the main page header & validate
            String sText = ch.findElement(By.tagName("h1")).getText();
            if(sText.equalsIgnoreCase("Main Page for Independent Frame")) System.out.println("Valid Header in main page");
            else System.out.println("Invalid header name in the main page");

            //3. Switch to the first frame (using index) and enter username and password
            ch.switchTo().frame(0);
            ch.findElement(By.id("frm1_un_id1")).sendKeys("admin");
            ch.findElement(By.id("frm1_pwd_id1")).sendKeys("manager");
            Thread.sleep(2000);


            //4. Switch back to the main page
            ch.switchTo().defaultContent();

            //5. Switch to the second frame(using id/name property) and select first checkbox
            ch.switchTo().frame("page2");
            ch.findElement(By.xpath("//input[@id='chkbox_id1']")).click();
            Thread.sleep(2000);

            //6. Switch back to the main page
            ch.switchTo().defaultContent();

            //7. close the browser
            ch.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ch = null;
        }
    }
}
