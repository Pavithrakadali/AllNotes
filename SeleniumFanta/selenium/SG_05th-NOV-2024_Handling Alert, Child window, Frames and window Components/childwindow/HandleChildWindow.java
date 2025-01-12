package childwindow;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;

public class HandleChildWindow {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        String sParent = null;
        try{
            //1. Open browser and navigate the URL
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.navigate().to("file:///C:/MorningBatch_Combined/HTML/WebPage/WebApplication.html");
            Thread.sleep(2000);

            //2. click on "Google India" link
            ch.findElement(By.xpath("//a[text()='Google India']")).click();

            //3. Read the parent window id
            sParent = ch.getWindowHandle();
            System.out.println(sParent);

            //4. Read the child window id & switch to the child window
            Thread.sleep(2000);
            Set<String> oChildWindow = ch.getWindowHandles();
            for(String child : oChildWindow){
                if(!child.equals(sParent)){
                    ch.switchTo().window(child);

                    //5. Perform few operations in the child window
                    System.out.println("TITLE: " + ch.getTitle());
                    System.out.println("URL: " + ch.getCurrentUrl());
                    Thread.sleep(2000);

                    //6. close the child window
                    ch.close();
                }
            }

            //7. switch back to parent window using parent window id
            ch.switchTo().window(sParent);
            Thread.sleep(2000);

            //8. close the browser
            ch.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ch = null;
        }
    }
}
