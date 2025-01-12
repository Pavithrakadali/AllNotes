package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class TextField_Validations {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        WebElement oEle = null;
        List<WebElement> oEles = null;
        String sText = null;
        try {
            //1. Open browser & navigate actiTime url
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.navigate().to("file:///C:/MorningBatch_Combined/HTML/WebPage/WebApplication.html");
            Thread.sleep(2000);
            System.out.println("***********************************");


            //1. Verify text fields exist/not?
            //case 1: Mandatory field (findElement)
            oEle = ch.findElement(By.id("frm1_un_id1"));
            if(oEle.isDisplayed() == true) System.out.println("Text field exist");
            else System.out.println("Failed to find the text field");
            System.out.println("***********************************");

            //case 2: Optional field/group of elements (findElements)
            oEles = ch.findElements(By.id("frm1_un_id1"));
            if(oEles.size() > 0) System.out.println("Text field exist");
            else System.out.println("Failed to find the text field");
            System.out.println("***********************************");


            //2. Enter the value in the text fields?
            oEles = ch.findElements(By.id("frm1_un_id1"));
            oEles.get(0).sendKeys("sdfsdfssssssssssssssss");
            Thread.sleep(2000);
            System.out.println("***********************************");

            //3. Read the value from the text field?
            sText = ch.findElement(By.id("frm1_un_id1")).getAttribute("value");
            if(sText.equalsIgnoreCase("sdfsdfssssssssssssssss")) System.out.println("Able to read the text from text field");
            else System.out.println("Failed to read the value from the text field");
            System.out.println("***********************************");


            //4. Clear the value from the text fields?
            ch.findElement(By.id("frm1_un_id1")).clear();
            Thread.sleep(2000);
            System.out.println("***********************************");


            //5. text fields enabled/disabled
            if(ch.findElement(By.id("frm1_un_id1")).isEnabled() == true) System.out.println("Text field is enabled");
            else System.out.println("Text field is disabled");
            System.out.println("***********************************");


            //6. Style attributes
            oEle = ch.findElement(By.id("frm1_un_id1"));
            System.out.println(oEle.getCssValue("color"));
            System.out.println(oEle.getCssValue("font-family"));
            System.out.println(oEle.getCssValue("font-size"));
            System.out.println("***********************************");


            //7. Height and width of text fields
            oEle = ch.findElement(By.id("frm1_un_id1"));
            System.out.println(oEle.getSize().getHeight());
            System.out.println(oEle.getSize().getWidth());
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            oEle = null;
            oEles = null;
            sText = null;
            ch = null;
        }
    }
}
