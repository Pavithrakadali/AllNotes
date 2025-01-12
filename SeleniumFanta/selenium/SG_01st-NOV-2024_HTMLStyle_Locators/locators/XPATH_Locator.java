package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPATH_Locator {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        try{
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.get("file:///C:/MorningBatch_Combined/HTML/WebPage/WebApplication.html");
            Thread.sleep(2000);

            //First username & password using absolute xpath
            ch.findElement(By.xpath("/html/body/form[@id='frm1']/input")).sendKeys("adminnnn");
            ch.findElement(By.xpath("/html/body/form[@id='frm1']/input[2]")).sendKeys("afafasfsafasfafaf");
            Thread.sleep(4000);

            //second username & password using absolute xpath
            ch.findElement(By.xpath("/html/body/form[2]/input")).sendKeys("adminnnn");
            ch.findElement(By.xpath("/html/body/form[2]/input[2]")).sendKeys("afafasfsafasfafaf");
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
