package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ActionsDemo3 {
    public static void main(String[] args) {
        WebDriver oBrowser = null;
        Actions oAction = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("https://marcojakob.github.io/dart-dnd/basic/");
            Thread.sleep(5000);

            oAction = new Actions(oBrowser);
            List<WebElement> oDocs = oBrowser.findElements(By.xpath("//img[@class='document']"));

            for(int i=0; i<oDocs.size(); i++){
                WebElement src = oBrowser.findElement(By.xpath("//img[@class='document']"));
                WebElement dest = oBrowser.findElement(By.xpath("//div[contains(@class, 'trash')]"));
                oAction.dragAndDrop(src, dest).perform();
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            oBrowser = null;
        }
    }
}
