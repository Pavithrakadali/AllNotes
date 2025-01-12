package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge_LoginLogout {
    public static void main(String[] args) {
        EdgeDriver edge = null;
        String strText = null;
        try{
            //1. Open browser
            edge = new EdgeDriver();
            edge.manage().window().maximize();

            //2. navigate the actiTime URL
            edge.get("http://localhost/login.do");
            Thread.sleep(2000);

            //3. enter username
            edge.findElement(By.id("username")).sendKeys("admin");

            //4. enter password
            edge.findElement(By.name("pwd")).sendKeys("manager");

            //5. click on Login button
            edge.findElement(By.id("loginButton")).click();
            Thread.sleep(2000);

            //6. Verify login is successful
            strText = edge.findElement(By.xpath("//td[@class='pagetitle']")).getText();
            if(strText.equalsIgnoreCase("Enter Time-Track")) System.out.println("Login to Application is successful");
            else {
                System.out.println("Failed to login to the actiTime application");
                return;
            }

            //7. click on Logout link
            edge.findElement(By.id("logoutLink")).click();
            Thread.sleep(2000);

            //8. Verify logout is successful
            if(edge.findElement(By.xpath("//img[contains(@src, '/timer.png?')]")).isDisplayed()){
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
            edge.close();
            edge = null;
        }
    }
}
