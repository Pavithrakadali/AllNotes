package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFox_LoginLogout {
    public static void main(String[] args) {
        FirefoxDriver ff = null;
        String strText = null;
        try{
            //1. Open browser
            ff = new FirefoxDriver();
            ff.manage().window().maximize();

            //2. navigate the actiTime URL
            ff.get("http://localhost/login.do");
            Thread.sleep(2000);

            //3. enter username
            ff.findElement(By.id("username")).sendKeys("admin");

            //4. enter password
            ff.findElement(By.name("pwd")).sendKeys("manager");

            //5. click on Login button
            ff.findElement(By.id("loginButton")).click();
            Thread.sleep(2000);

            //6. Verify login is successful
            strText = ff.findElement(By.xpath("//td[@class='pagetitle']")).getText();
            if(strText.equalsIgnoreCase("Enter Time-Track")) System.out.println("Login to Application is successful");
            else {
                System.out.println("Failed to login to the actiTime application");
                return;
            }

            //7. click on Logout link
            ff.findElement(By.id("logoutLink")).click();
            Thread.sleep(2000);

            //8. Verify logout is successful
            if(ff.findElement(By.xpath("//img[contains(@src, '/timer.png?')]")).isDisplayed()){
                System.out.println("Logout from actiTime is successful");
            }else{
                System.out.println("Failed to logout from ActiTime");
                return;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            //9. close the browser
            ff.close();
            ff = null;
        }
    }
}
