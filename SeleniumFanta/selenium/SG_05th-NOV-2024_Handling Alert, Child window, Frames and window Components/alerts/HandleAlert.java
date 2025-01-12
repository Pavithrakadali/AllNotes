package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlert {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        try{
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.get("file:///C:/Users/prabh/OneDrive/Documents/Sg%20Testing/TestCaseTemplates/Automation/Alerts%20Page/SampleAlertsDemo.html");
            Thread.sleep(2000);

            //Click on the 'alertBtn' button, it will show the alert
            ch.findElement(By.id("btn_id1")).click();
            Thread.sleep(2000);

            //Handle the alert
            //Read the alert text
            //click on OK button
            Alert oAlert = ch.switchTo().alert();
            System.out.println(oAlert.getText());

            oAlert.accept();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ch.close();
            ch = null;
        }
    }
}
