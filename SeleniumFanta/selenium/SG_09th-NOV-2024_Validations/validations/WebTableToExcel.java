package validations;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileOutputStream;
import java.util.List;

public class WebTableToExcel {
    public static void main(String[] args) {
        ChromeDriver ch = null;
        FileOutputStream fout = null;
        Workbook wb = null;
        Sheet sh = null;
        Row row = null;
        Cell cell = null;
        WebElement oEle = null;
        try{
            ch = new ChromeDriver();
            ch.manage().window().maximize();
            ch.navigate().to("file:///C:/MorningBatch_Combined/HTML/WebTable/WebTableApplication.html");
            Thread.sleep(2000);
            wb = new XSSFWorkbook();
            sh = wb.createSheet("STUDENTs");
            List<WebElement> oRows = ch.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
            for(int r=0; r<oRows.size(); r++){
                row = sh.createRow(r);
                List<WebElement> oColumns = ch.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/th"));
                for(int c=0; c<oColumns.size(); c++){
                    cell = row.createCell(c);
                    oEle = ch.findElement(By.xpath("//table[@id='table1']/tbody/tr["+(r+1)+"]/*["+(c+1)+"]"));
                    cell.setCellValue(oEle.getText());
                }
            }

            fout = new FileOutputStream("C:\\MorningBatch_Combined\\STUDENT.xlsx");
            wb.write(fout);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                fout.flush();
                fout.close();
                fout = null;
                cell = null;
                row = null;
                sh = null;
                wb.close();
                wb = null;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
