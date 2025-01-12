package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlePromptAlert {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        try{
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.get("file:///C:/Users/prabh/OneDrive/Documents/Sg%20Testing/TestCaseTemplates/Automation/Alerts%20Page/SampleAlertsDemo.html");
            Thread.sleep(2000);

            //Click on the 'PromptBtn' button, it will show the alert
            ch.findElement(By.id("btn_id3")).click();
            Thread.sleep(2000);

            //Handle the alert
            //Read the alert text
            //click on OK button
            Alert oAlert = ch.switchTo().alert();
            System.out.println(oAlert.getText());
            String userName = "SG Testing Institute";
            oAlert.sendKeys(userName);
            Thread.sleep(2000);
            oAlert.accept();
            Thread.sleep(2000);


            //Verify user clicked OK button
            String sText = ch.findElement(By.xpath("//body")).getText();
            if(sText.equalsIgnoreCase("User Name is: "+userName)) System.out.println("OK button is clicked");
            else System.out.println("User Failed to click OK button");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ch.close();
            ch = null;
        }
    }
}
