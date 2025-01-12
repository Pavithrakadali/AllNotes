package robotClass;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class NaukriUploadWindow_RobotClass {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        Robot robot = null;
        Clipboard clipboard = null;
        StringSelection path = null;
        try{
            //1. Open browser and navigate to "https://www.naukri.com/"
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.navigate().to("https://www.naukri.com/");
            Thread.sleep(2000);

            //2. click on "Register" link.
            ch.findElement(By.xpath("//a[@id='register_Layer']")).click();
            Thread.sleep(2000);

            //3. Enter the required details viz., Full Name, Email ID, Password, Mobile number (Optional)
            ch.findElement(By.xpath("//input[@id='name']")).sendKeys("sg Testing");
            ch.findElement(By.xpath("//input[@id='email']")).sendKeys("sgtesting@sg.com");
            ch.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin@123");
            ch.findElement(By.xpath("//input[@id='mobile']")).sendKeys("9988556644");


            //4. Select the work status as "I'm Experienced"
            ch.findElement(By.xpath("//p[contains(text(), 'work experience')]")).click();
            Thread.sleep(2000);

            //5. click on the "Upload Resume" button
            ch.findElement(By.xpath("//button[text()='Upload Resume']")).click();
            Thread.sleep(4000);

            //6. Handle the Upload window component using Robot class
            path = new StringSelection("C:\\MorningBatch_Combined\\MyResume.docx");
            clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(path, null);

            robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);

            String cvName = ch.findElement(By.xpath("//span[@class='file-name ellipsis']")).getText();
            if(cvName.equalsIgnoreCase("MyResume.docx")) System.out.println("CV Uploaded successful");
            else System.out.println("Failed to upload the CV");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ch = null;
        }
    }
}
