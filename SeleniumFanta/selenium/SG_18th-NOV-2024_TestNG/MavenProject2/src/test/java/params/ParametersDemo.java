package params;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemo {
    @Parameters({"appURL", "userName", "password"})
    @Test
    public void testScript1(String url, String userName, String password){
        WebDriver oBrowser = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to(url);
            Thread.sleep(2000);

            oBrowser.findElement(By.id("username")).sendKeys(userName);
            oBrowser.findElement(By.name("pwd")).sendKeys(password);
            oBrowser.findElement(By.id("loginButton")).click();
            Thread.sleep(2000);

            oBrowser.findElement(By.id("logoutLink")).click();
            Thread.sleep(2000);

            oBrowser.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            oBrowser = null;
        }
    }
}
