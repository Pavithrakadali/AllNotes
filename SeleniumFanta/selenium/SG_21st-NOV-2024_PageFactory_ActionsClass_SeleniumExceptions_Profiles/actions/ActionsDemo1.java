package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo1 {
    public static void main(String[] args) {
        WebDriver oBrowser = null;
        Actions oAction = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("http://localhost/login.do");
            Thread.sleep(2000);

            oAction = new Actions(oBrowser);
            oAction.sendKeys(oBrowser.findElement(By.id("username")), "admin").perform();
            oAction.sendKeys(oBrowser.findElement(By.name("pwd")), "manager").perform();
            oAction.click(oBrowser.findElement(By.id("loginButton"))).perform();
            Thread.sleep(2000);

            WebElement oEle = oBrowser.findElement(By.xpath("//td[@class='pagetitle']"));
            oAction.doubleClick(oEle).perform();
            Thread.sleep(2000);
            oAction.contextClick(oEle).perform();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            oBrowser = null;
        }
    }
}
