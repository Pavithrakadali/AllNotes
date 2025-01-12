package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class WebTable_Validations {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        WebElement oEle = null;
        List<WebElement> oEles = null;
        String sText = null;
        Select oSelect = null;
        String xpath = null;
        try {
            //Open browser & navigate actiTime url
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.navigate().to("file:///C:/MorningBatch_Combined/HTML/WebTable/WebTableApplication.html");
            Thread.sleep(2000);
            System.out.println("***********************************");


            //1. Verify webtable exist/not?
            //case 1: Mandatory field (findElement)
            oEle = ch.findElement(By.xpath("//table[@id='table1']"));
            if(oEle.isDisplayed() == true) System.out.println("webtable exist");
            else System.out.println("Failed to find the webtable");
            System.out.println("***********************************");

            //case 2: Optional field/group of elements (findElements)
            oEles = ch.findElements(By.xpath("//table[@id='table1']"));
            if(oEles.size() > 0) System.out.println("webtable exist");
            else System.out.println("Failed to find the webtable");
            System.out.println("***********************************");


            //2. How many rows and columns in a student table?
            List<WebElement> oRows = ch.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
            System.out.println("No. of Rows: " + oRows.size());

            List<WebElement> oColumns = ch.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/th"));
            System.out.println("No. of Columns: " + oColumns.size());
            System.out.println("**************************************");


            //3. Read the column header from the student table?
            List<WebElement> colHeader = ch.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/th"));
            for(int i=0; i<colHeader.size(); i++){
                System.out.println(colHeader.get(i).getText());
            }
            System.out.println("**************************************");

            //4. Read the male student names from student table?
            xpath = "//table[@id='table1']//td[text()='Male']/preceding-sibling::td[3]";
            oEles = ch.findElements(By.xpath(xpath));
            for(int i=0; i<oEles.size(); i++){
                System.out.println(oEles.get(i).getText());
            }
            System.out.println("**************************************");


            //5. Select city Tamil Nadu for Abdul Kalam?
            xpath = "//table[@id='table2']//td[text()='Abdul Kalam']/following-sibling::td/select";
            oSelect = new Select(ch.findElement(By.xpath(xpath)));
            oSelect.selectByVisibleText("Tamil Nadu");
            System.out.println("**************************************");

            //6. Read the person name from person table whose age is 35?
            xpath = "//table[@id='table2']//td[text()='35']/preceding-sibling::td[5]";
            oEle = ch.findElement(By.xpath(xpath));
            System.out.println(oEle.getText());
            System.out.println("**************************************");


            //7. Based on the given cityname, read the description?
            String cityName = "Bangalore";
            xpath = "//table[@id='table3']//td[text()='"+cityName+"']/following-sibling::td/*/li";
            oEles = ch.findElements(By.xpath(xpath));
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
