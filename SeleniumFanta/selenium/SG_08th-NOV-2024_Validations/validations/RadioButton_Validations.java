package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButton_Validations {
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


            //1. Verify radio button exist/not?
            //case 1: Mandatory field (findElement)
            oEle = ch.findElement(By.xpath("//input[@id='male']"));
            if(oEle.isDisplayed() == true) System.out.println("radio Button exist");
            else System.out.println("Failed to find the radio Button Exist");
            System.out.println("***********************************");

            //case 2: Optional field/group of elements (findElements)
            oEles = ch.findElements(By.xpath("//input[@id='male']"));
            if(oEles.size() > 0) System.out.println("radio Button exist");
            else System.out.println("Failed to find the radio Button Exist");
            System.out.println("***********************************");


            //2. How to select the radio button
            ch.findElement(By.xpath("//input[@id='male']")).click();
            System.out.println("***********************************");

            //3. radio button is selected or not?
            oEle = ch.findElement(By.xpath("//input[@id='male']"));
            if(oEle.isSelected() == true) System.out.println("The radio button is selected");
            else System.out.println("Failed to select the radio Button");
            System.out.println("***********************************");


            //4. How many radio button exist? click the second radio button?
            //5. Selecting one radio button should unselect another radio button?
            oEles = ch.findElements(By.xpath("//input[@type='radio']"));
            System.out.println("No. of Radio buttons: " + oEles.size());
            oEles.get(1).click();

            if(oEles.get(0).isSelected()==false && oEles.get(1).isSelected()==true) System.out.println("Radio buttons are working as per the std");
            else System.out.println("Radio button stds are not applied");
            System.out.println("***********************************");


            //6. radio button enabled/disabled
            if(ch.findElement(By.xpath("//input[@id='male']")).isEnabled() == true) System.out.println("Radio Button is enabled");
            else System.out.println("Radio Button is disabled");
            System.out.println("***********************************");


            //7. Style attributes
            oEle = ch.findElement(By.xpath("//input[@id='male']"));
            System.out.println(oEle.getCssValue("color"));
            System.out.println(oEle.getCssValue("font-family"));
            System.out.println(oEle.getCssValue("font-size"));
            System.out.println("***********************************");


            //8. Height and width
            oEle = ch.findElement(By.xpath("//input[@id='male']"));
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
