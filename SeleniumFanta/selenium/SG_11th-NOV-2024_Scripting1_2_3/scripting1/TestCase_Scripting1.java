package scripting1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_Scripting1 {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        try{
            //1. Open browser & navigate actiTime url
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.navigate().to("http://localhost/login.do");
            Thread.sleep(2000);


            //2. enter username and password & click on Login button
            ch.findElement(By.id("username")).sendKeys("admin");
            ch.findElement(By.name("pwd")).sendKeys("manager");
            ch.findElement(By.id("loginButton")).click();
            Thread.sleep(2000);

            ch.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();


            //3. Click on USERS menu
            ch.findElement(By.xpath("//div[text()='USERS']")).click();
            Thread.sleep(2000);

            //4. click on "Add Users' button
            ch.findElement(By.xpath("//div[text()='Add User']")).click();
            Thread.sleep(2000);


            //5. Enter all the required details for creating new user viz., First Name, Last Name, Email, UserName, Password and retype password.
            ch.findElement(By.xpath("//input[@name='firstName']")).sendKeys("sg");
            ch.findElement(By.xpath("//input[@name='lastName']")).sendKeys("tester");
            ch.findElement(By.xpath("//input[@name='email']")).sendKeys("sg.tester@sg.com");
            ch.findElement(By.xpath("//input[@name='username']")).sendKeys("sgtester");
            ch.findElement(By.xpath("//input[@name='password']")).sendKeys("Mercury@1");
            ch.findElement(By.xpath("//input[@name='passwordCopy']")).sendKeys("Mercury@1");

            //6. Click on "Create User" button
            ch.findElement(By.xpath("//span[text()='Create User']")).click();
            Thread.sleep(2000);

            //7. A new user is created. Click on the newly created user and delete it
            ch.findElement(By.xpath("//div[@class='name']/span[text()='tester, sg']")).click();
            Thread.sleep(2000);

            ch.findElement(By.xpath("//button[contains(text(), 'Delete User')]")).click();
            Thread.sleep(2000);
            ch.switchTo().alert().accept();
            Thread.sleep(2000);

            //8. logout from actiTime
            ch.findElement(By.xpath("//a[@id='logoutLink']")).click();
            Thread.sleep(2000);

            //9. Close the browser
            ch.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ch = null;
        }
    }
}