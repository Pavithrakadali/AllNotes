package dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
    @DataProvider(name="data", parallel = true)
    public Object[][] testData(){
        return new Object[][] {{"Chrome", "http://localhost/login.do","admin","manager"},
                {"Chrome", "http://localhost/login.do","admin","manager"},
                {"Chrome", "http://localhost/login.do","admin","manager"},
                {"Chrome", "http://localhost/login.do","admin","manager"}
        };
    }

    @Test(dataProvider = "data")
    public void testScript1(String browserName, String url, String userName, String password){
        WebDriver oBrowser = null;
        try{
            if(browserName.toLowerCase().equalsIgnoreCase("Chrome"))
                oBrowser = new ChromeDriver();
            else if(browserName.toLowerCase().equalsIgnoreCase("Edge"))
                oBrowser = new EdgeDriver();
            else if(browserName.toLowerCase().equalsIgnoreCase("FireFox"))
                oBrowser = new FirefoxDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to(url);
            Thread.sleep(2000);

            oBrowser.findElement(By.id("username")).sendKeys(userName);
            oBrowser.findElement(By.name("pwd")).sendKeys(password);
            oBrowser.findElement(By.id("loginButton")).click();
            Thread.sleep(2000);

            oBrowser.findElement(By.id("logoutLink")).click();
            Thread.sleep(2000);


        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            oBrowser.close();
            oBrowser = null;
        }
    }
}
