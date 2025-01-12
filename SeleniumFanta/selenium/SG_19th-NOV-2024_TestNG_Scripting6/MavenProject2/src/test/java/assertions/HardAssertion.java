package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
    @Test
    public void testScript1(){
        WebDriver oBrowser = null;
        Assert.assertNull(oBrowser, "The browser object is not null");
        try{
            oBrowser = new ChromeDriver();
            Assert.assertNotNull(oBrowser, "The oBrowser object is still null");

            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("http://localhost/login.do");
            Thread.sleep(2000);
            Assert.assertEquals(oBrowser.getTitle(), "actiTIME - Login", "The expected title didn't match");

            oBrowser.findElement(By.id("username")).sendKeys("admin");
            oBrowser.findElement(By.name("pwd")).sendKeys("manager");
            oBrowser.findElement(By.id("loginButton")).click();
            Thread.sleep(2000);
            Assert.assertTrue(oBrowser.findElement(By.xpath("//img[contains(@src, 'default-logo.png')]")).isDisplayed(), "The element was not displayed");

            oBrowser.findElement(By.id("logoutLink")).click();
            Thread.sleep(2000);
            WebElement oEle = oBrowser.findElement(By.id("headerContainer"));
            Assert.assertEquals(oEle.getText(), "Please identify yourself", "The expected login header was not displayed");
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            oBrowser.close();
            oBrowser = null;
        }
    }
}
