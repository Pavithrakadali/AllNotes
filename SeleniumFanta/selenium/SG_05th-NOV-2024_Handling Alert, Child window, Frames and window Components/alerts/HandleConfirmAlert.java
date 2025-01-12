package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleConfirmAlert {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        try{
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.get("file:///C:/Users/prabh/OneDrive/Documents/Sg%20Testing/TestCaseTemplates/Automation/Alerts%20Page/SampleAlertsDemo.html");
            Thread.sleep(2000);

            //Click on the 'ConfirmBtn' button, it will show the alert
            ch.findElement(By.id("btn_id2")).click();
            Thread.sleep(2000);

            //Handle the alert
            //Read the alert text
            //click on OK button
            Alert oAlert = ch.switchTo().alert();
            System.out.println(oAlert.getText());

            oAlert.accept();

            //Verify user clicked OK button
            String sText = ch.findElement(By.xpath("//body")).getText();
            if(sText.equalsIgnoreCase("User clicked OK button")) System.out.println("OK button is clicked");
            else System.out.println("User Failed to clock OK button");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ch.close();
            ch = null;
        }
    }
}
