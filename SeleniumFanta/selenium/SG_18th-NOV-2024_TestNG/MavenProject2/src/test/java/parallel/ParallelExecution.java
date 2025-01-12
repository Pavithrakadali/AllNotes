package parallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ParallelExecution {
    @Test()
    public void testScript1(){
        WebDriver oBrowser = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("http://localhost/login.do");
            Thread.sleep(2000);

            oBrowser.findElement(By.id("username")).sendKeys("admin");
            oBrowser.findElement(By.name("pwd")).sendKeys("manager");
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

    @Test()
    public void testScript2(){
        WebDriver oBrowser = null;
        try{
            oBrowser = new EdgeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("http://localhost/login.do");
            Thread.sleep(2000);

            oBrowser.findElement(By.id("username")).sendKeys("admin");
            oBrowser.findElement(By.name("pwd")).sendKeys("manager");
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

    @Test()
    public void testScript3(){
        WebDriver oBrowser = null;
        try{
            oBrowser = new FirefoxDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("http://localhost/login.do");
            Thread.sleep(2000);

            oBrowser.findElement(By.id("username")).sendKeys("admin");
            oBrowser.findElement(By.name("pwd")).sendKeys("manager");
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

    @Test()
    public void testScript4(){
        WebDriver oBrowser = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("http://localhost/login.do");
            Thread.sleep(2000);

            oBrowser.findElement(By.id("username")).sendKeys("admin");
            oBrowser.findElement(By.name("pwd")).sendKeys("manager");
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

    @Test()
    public void testScript5(){
        WebDriver oBrowser = null;
        try{
            oBrowser = new EdgeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("http://localhost/login.do");
            Thread.sleep(2000);

            oBrowser.findElement(By.id("username")).sendKeys("admin");
            oBrowser.findElement(By.name("pwd")).sendKeys("manager");
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
