package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo2 {
    public static void main(String[] args) {
        WebDriver oBrowser = null;
        Actions oAction = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("https://www.flipkart.com/");
            Thread.sleep(5000);

            oAction = new Actions(oBrowser);
            oAction.clickAndHold(oBrowser.findElement(By.xpath("//img[@alt='Grocery']"))).perform();
            Thread.sleep(2000);

            oAction.moveToElement(oBrowser.findElement(By.xpath("//img[@alt='Fashion']"))).perform();
            Thread.sleep(2000);

            oAction.click(oBrowser.findElement(By.xpath("//a[contains(text(), 's T-Shirts')]"))).perform();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            oBrowser = null;
        }
    }
}
