package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaits {
    public static void main(String[] args) {
        WebDriver oBrowser = null;
        WebDriverWait oWait = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("http://localhost/login.do");

            oWait = new WebDriverWait(oBrowser, Duration.ofSeconds(20));

            //Wait for the element to appear
            oWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));

            //Wait for the element to visible
            oWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));

            //Wait for the element to become clickable
            oWait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));


            //Wait for the text to appear
            oWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(""), ""));

            //Wait for the value to appear
            oWait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath(""), ""));

            //Wait for the invisibility of element
            oWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("")));

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            oBrowser = null;
        }
    }
}
