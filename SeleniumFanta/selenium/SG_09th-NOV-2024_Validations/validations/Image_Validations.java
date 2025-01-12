package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Image_Validations {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        WebElement oEle = null;
        List<WebElement> oEles = null;
        String sText = null;
        Select oSelect = null;
        try {
            //Open browser & navigate actiTime url
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.navigate().to("file:///C:/MorningBatch_Combined/HTML/WebPage/WebApplication.html");
            Thread.sleep(2000);
            System.out.println("***********************************");


            //1. Verify images exist/not?
            //case 1: Mandatory field (findElement)
            oEle = ch.findElement(By.xpath("//img[contains(@src,'duck')]"));
            if(oEle.isDisplayed() == true) System.out.println("images exist");
            else System.out.println("Failed to find the images");
            System.out.println("***********************************");

            //case 2: Optional field/group of elements (findElements)
            oEles = ch.findElements(By.xpath("//img[contains(@src,'duck')]"));
            if(oEles.size() > 0) System.out.println("images exist");
            else System.out.println("Failed to find the images");
            System.out.println("***********************************");


            //2. How many images?
            oEles = ch.findElements(By.tagName("img"));
            System.out.println("No. of Images: " + oEles.size());
            System.out.println("***********************************");


            //3. How many images with alt tag?
            oEles = ch.findElements(By.xpath("//img[@alt]"));
            System.out.println("No. of Images with Alt tag: " + oEles.size());
            for(int i=0; i<oEles.size(); i++){
                System.out.println(oEles.get(i).getAttribute("src"));
            }
            System.out.println("***********************************");


            //4. How many images with without alt tag?
            oEles = ch.findElements(By.cssSelector("img:not([alt])"));
            System.out.println("No. of Images without Alt tag: " + oEles.size());
            for(int i=0; i<oEles.size(); i++){
                System.out.println(oEles.get(i).getAttribute("src"));
            }
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
