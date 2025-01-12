package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Paragraphs_Validations {
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


            //1. Verify paragraph exist/not?
            //case 1: Mandatory field (findElement)
            oEle = ch.findElement(By.xpath("//p/b[contains(text(), 'Two')]"));
            if(oEle.isDisplayed() == true) System.out.println("paragraph exist");
            else System.out.println("Failed to find the paragraph Exist");
            System.out.println("***********************************");

            //case 2: Optional field/group of elements (findElements)
            oEles = ch.findElements(By.xpath("//p/b[contains(text(), 'Two')]"));
            if(oEles.size() > 0) System.out.println("paragraph exist");
            else System.out.println("Failed to find the paragraph");
            System.out.println("***********************************");


            //2. Read the value from the paragraph?
            sText = ch.findElement(By.xpath("//p/b[contains(text(), 'Two')]")).getText();
            System.out.println(sText);
            System.out.println("***********************************");



            //3. How many paragraph exist? read the second paragraph text?
            oEles = ch.findElements(By.xpath("//*[contains(text(), 'Para')]"));
            System.out.println("No. of Paragraphs: " + oEles.size());
            for(int i=0; i<oEles.size(); i++){
                System.out.println(oEles.get(i).getText());
            }
            System.out.println(oEles.get(1).getText());
            System.out.println("***********************************");


            //4. paragraph enabled/disabled
            if(ch.findElement(By.xpath("//*[contains(text(), 'Para')]")).isEnabled() == true) System.out.println("Paragraph is enabled");
            else System.out.println("Paragraph is disabled");
            System.out.println("***********************************");


            //5. Style attributes
            oEle = ch.findElement(By.xpath("//*[contains(text(), 'Para')]"));
            System.out.println(oEle.getCssValue("color"));
            System.out.println(oEle.getCssValue("font-family"));
            System.out.println(oEle.getCssValue("font-size"));
            System.out.println("***********************************");


            //6. Height and width of text fields
            oEle = ch.findElement(By.xpath("//*[contains(text(), 'Para')]"));
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
