package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Link_Validations {
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


            //1. Verify link exist/not?
            //case 1: Mandatory field (findElement)
            oEle = ch.findElement(By.xpath("//a[@id='link_id1']"));
            if(oEle.isDisplayed() == true) System.out.println("link exist");
            else System.out.println("Failed to find the link Exist");
            System.out.println("***********************************");

            //case 2: Optional field/group of elements (findElements)
            oEles = ch.findElements(By.xpath("//a[@id='link_id1']"));
            if(oEles.size() > 0) System.out.println("link exist");
            else System.out.println("Failed to find the link");
            System.out.println("***********************************");


            //2. how to click the link?
            ch.findElement(By.id("link_id3")).click();
            Thread.sleep(2000);
            ch.navigate().back();
            Thread.sleep(2000);
            System.out.println("***********************************");


            //3. How many links? Read the link text? Click the 2nd link?
            String sParent = ch.getWindowHandle();
            oEles = ch.findElements(By.tagName("a"));
            System.out.println("No. of links are: " + oEles.size());
            for(int i=0; i<oEles.size(); i++){
                System.out.println(oEles.get(i).getText());
            }
            oEles.get(1).click();
            Thread.sleep(2000);

            Object arr[] = ch.getWindowHandles().toArray();
            ch.switchTo().window(arr[1].toString());
            Thread.sleep(2000);

            System.out.println(ch.getTitle());
            System.out.println(ch.getCurrentUrl());
            ch.close();
            ch.switchTo().window(sParent);
            System.out.println("***********************************");


            //4. How many links opens in a new tab/page?
            oEles = ch.findElements(By.xpath("//a[@target]"));
            System.out.println("No. of links opens in a new Tab/page: " + oEles.size());
            for(int i=0; i<oEles.size(); i++){
                System.out.println(oEles.get(i).getText());
            }
            System.out.println("***********************************");

            //5. How many links doesnot opens in a new tab/page?
            oEles = ch.findElements(By.xpath("//a[not(@target)]"));
            System.out.println("No. of links opens in a same page: " + oEles.size());
            for(int i=0; i<oEles.size(); i++){
                System.out.println(oEles.get(i).getText());
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
