package naukriUsingAutoit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaukriUploadWindow_SendKeys {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        String exeFilePath = null;
        String fileDestPath = null;
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

            //6. Handle the Upload window component using sendKeys (The element type should be file)
            ch.findElement(By.xpath("//input[@id='resumeUpload']")).sendKeys("C:\\MorningBatch_Combined\\autoItSampleScriptsDemo\\MyResume.docx");
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
