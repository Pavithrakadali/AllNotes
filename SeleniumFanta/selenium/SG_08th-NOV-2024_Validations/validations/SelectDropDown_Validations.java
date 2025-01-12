package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDropDown_Validations {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        WebElement oEle = null;
        List<WebElement> oEles = null;
        String sText = null;
        Select oSelect = null;
        try {
            //1. Open browser & navigate actiTime url
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.navigate().to("file:///C:/MorningBatch_Combined/HTML/WebPage/WebApplication.html");
            Thread.sleep(2000);
            System.out.println("***********************************");


            //1. Verify dropdown exist/not?
            //case 1: Mandatory field (findElement)
            oEle = ch.findElement(By.xpath("//select[@id='list1']"));
            if(oEle.isDisplayed() == true) System.out.println("dropdown exist");
            else System.out.println("Failed to find the dropdown Exist");
            System.out.println("***********************************");

            //case 2: Optional field/group of elements (findElements)
            oEles = ch.findElements(By.xpath("//select[@id='list1']"));
            if(oEles.size() > 0) System.out.println("dropdown exist");
            else System.out.println("Failed to find the dropdown");
            System.out.println("***********************************");


            //2. How to select the dropdown value?
            //3. How to read the selected value from the dropdown?
            //There are 3 ways
            //(a) .selectByIndex()
            //(b) .selectByValue()
            //(c) .selectByVisibleText()
            oEle = ch.findElement(By.xpath("//select[@id='list1']"));
            oSelect = new Select(oEle);
            oSelect.selectByIndex(1);
            Thread.sleep(2000);
            System.out.println(oSelect.getFirstSelectedOption().getText());

            oSelect.selectByValue("bl");
            Thread.sleep(2000);
            System.out.println(oSelect.getFirstSelectedOption().getText());

            oSelect.selectByVisibleText("Managalore");
            Thread.sleep(2000);
            System.out.println(oSelect.getFirstSelectedOption().getText());
            System.out.println("***********************************");


            //4. How to select the value from the multi-select dropdown?
            //5. How to read the values from the multi-select dropdown?
            //6. How to de-select the value from the multi-select drop down?
            oEle = ch.findElement(By.xpath("//select[@id='list2']"));
            oSelect = new Select(oEle);
            oSelect.selectByVisibleText("Raichur");
            oSelect.selectByVisibleText("Bangalore");
            oSelect.selectByVisibleText("Bellary");

            List<WebElement> oValues = oSelect.getAllSelectedOptions();
            for(int i=0; i<oValues.size(); i++){
                System.out.println(oValues.get(i).getText());
            }

            //How to de-select from multi-select dropdown
            //(a) .deselectAll();
            //(b) .deselectByIndex();
            //(c) .deselectByValue();
            //(d) .deselectByVisisbleText()
            Thread.sleep(2000);
            oSelect.deselectAll();
            System.out.println("***********************************");


            //8. How to read all the dropdown values?
            //7. Verify the given city is present in the dropdown?
            oEle = ch.findElement(By.xpath("//select[@id='list1']"));
            oSelect = new Select(oEle);
            String cityName = "Goa";
            List<WebElement> options = oSelect.getOptions();
            int flag = 0;
            for(int i=0; i<options.size(); i++){
                if(options.get(i).getText().equalsIgnoreCase(cityName)){
                    flag++;
                    break;
                }
            }

            if(flag==0) System.out.println("The city '"+cityName+"' not present");
            else System.out.println("The city '"+cityName+"' present");


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
