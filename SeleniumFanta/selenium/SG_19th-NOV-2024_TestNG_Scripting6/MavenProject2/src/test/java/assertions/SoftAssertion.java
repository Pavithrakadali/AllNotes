package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
    @Test
    public void testScript1(){
        WebDriver oBrowser = null;
        SoftAssert soft = new SoftAssert();
        soft.assertNull(oBrowser, "The browser object is not null");
        try{
            oBrowser = new ChromeDriver();
            soft.assertNotNull(oBrowser, "The oBrowser object is still null");

            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("http://localhost/login.do");
            Thread.sleep(2000);
            soft.assertEquals(oBrowser.getTitle(), "actiTIME - Login1111", "The expected title didn't match");

            oBrowser.findElement(By.id("username")).sendKeys("admin");
            oBrowser.findElement(By.name("pwd")).sendKeys("manager");
            oBrowser.findElement(By.id("loginButton")).click();
            Thread.sleep(2000);
            soft.assertTrue(oBrowser.findElement(By.xpath("//img[contains(@src, 'default-logo.png')]")).isDisplayed(), "The element was not displayed");

            oBrowser.findElement(By.id("logoutLink")).click();
            Thread.sleep(2000);
            WebElement oEle = oBrowser.findElement(By.id("headerContainer"));
            soft.assertEquals(oEle.getText(), "Please identify yourself", "The expected login header was not displayed");

            soft.assertAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            oBrowser.close();
            oBrowser = null;
        }
    }
}
