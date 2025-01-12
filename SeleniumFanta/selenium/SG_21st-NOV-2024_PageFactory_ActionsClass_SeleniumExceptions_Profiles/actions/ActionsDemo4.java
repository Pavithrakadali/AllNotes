package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo4 {
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
            Thread.sleep(2000);
            oAction.doubleClick(oBrowser.findElement(By.id("username"))).perform();
            Thread.sleep(2000);
            for(int i=0; i<5; i++){
                oAction.keyDown(oBrowser.findElement(By.id("username")), Keys.BACK_SPACE).perform();
            }
            oAction.sendKeys(oBrowser.findElement(By.id("username")), "admin").perform();


            oAction.sendKeys(oBrowser.findElement(By.name("pwd")), "manager").perform();
            oAction.keyDown(oBrowser.findElement(By.id("loginButton")), Keys.ENTER).perform();
            Thread.sleep(2000);


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            oBrowser = null;
        }
    }
}
