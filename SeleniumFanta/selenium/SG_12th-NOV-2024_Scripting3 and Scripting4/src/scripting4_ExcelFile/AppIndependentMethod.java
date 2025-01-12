package scripting4_ExcelFile;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppIndependentMethod{
    /******************************************************************
     * Method Name      : launchBrowser()
     * purpose          : This method launches the browsers based on input
     *                  : supported browsers: Chrome, Firefox and Edge
     * Author           : sgTester1
     * Reviewed By      : sgTester2
     * Parameters       : browserName
     ******************************************************************/
    public WebDriver launchBrowser(String browserName){
        WebDriver oDriver = null;
        try{
            switch(browserName.toLowerCase()){
                case "chrome":
                    oDriver = new ChromeDriver();
                    break;
                case "firefox":
                    oDriver = new FirefoxDriver();
                    break;
                case "edge":
                    oDriver = new EdgeDriver();
                    break;
                default:
                    System.out.println("Invalid '"+browserName+"' browser name was mentioned. Please specified valid broswer name");
                    return null;
            }
            if(oDriver==null){
                System.out.println("Failed to launch '"+browserName+"' browser");
                return null;
            }else{
                System.out.println("The '"+browserName+"' browser is launched successful");
                oDriver.manage().window().maximize();
                return oDriver;
            }
        }catch(Exception e){
            System.out.println("Exception in the method 'launchBrowser()': " + e);
            return null;
        }
    }



    /******************************************************************
     * Method Name      : clickObject()
     * purpose          :
     * Author           : sgTester1
     * Parameters       : oBrowser, strURL
     ******************************************************************/
    public boolean clickObject(WebDriver oBrowser, By objBy){
        WebElement oEle = null;
        boolean blnRes = false;
        try{
            oEle = oBrowser.findElement(objBy);
            if(oEle.isDisplayed()){
                oEle.click();
                System.out.println("The element '"+objBy+"' was clicked successful");
                blnRes = true;
            }
            return blnRes;
        }catch(Exception e){
            System.out.println("Exception in the method 'clickObject()': " + e);
            return false;
        }
        finally {
            oEle = null;
        }
    }


    /******************************************************************
     * Method Name      : clickObject()
     * purpose          :
     * Author           : sgTester1
     * Parameters       : oBrowser, strURL
     ******************************************************************/
    public boolean setObject(WebDriver oBrowser, By objBy, String strData){
        WebElement oEle = null;
        boolean blnRes = false;
        try{
            oEle = oBrowser.findElement(objBy);
            if(oEle.isDisplayed()){
                oEle.sendKeys(strData);
                System.out.println("The data '"+strData+"' is entered in the element '"+objBy+"' successful");
                blnRes = true;
            }
            return blnRes;
        }catch(Exception e){
            System.out.println("Exception in the method 'setObject()': " + e);
            return false;
        }
        finally {
            oEle = null;
        }
    }


    /******************************************************************
     * Method Name      : compareValues()
     * purpose          :
     * Author           : sgTester1
     * Parameters       : oBrowser, strURL
     ******************************************************************/
    public boolean compareValues(WebDriver oBrowser, String actual, String expected){
        try{
            if(actual.equalsIgnoreCase(expected)){
                System.out.println("The actual '"+actual+"' & expected '"+expected+"' values are matched");
                return true;
            }else{
                System.out.println("Mis-match in the actual '"+actual+"' & expected '"+expected+"' values");
                return false;
            }
        }catch(Exception e){
            System.out.println("Exception in the method 'compareValues()': " + e);
            return false;
        }
    }


    /******************************************************************
     * Method Name      : verifyText()
     * purpose          :
     * Author           : sgTester1
     * Parameters       : oBrowser, strURL
     ******************************************************************/
    public boolean verifyText(WebDriver oBrowser, By objBy, String elementType, String expected){
        WebElement oEle = null;
        Select oSelect = null;
        String actual = null;
        boolean blnRes = false;
        try{
            oEle = oBrowser.findElement(objBy);
            if(oEle.isDisplayed()){
                switch(elementType.toLowerCase()){
                    case "text":
                        actual = oEle.getText();
                        break;
                    case "value":
                        actual = oEle.getAttribute("value");
                        break;
                    case "dropdown":
                        oSelect = new Select(oEle);
                        actual = oSelect.getFirstSelectedOption().getText();
                        break;
                    default:
                        System.out.println("Invalid element Type '"+elementType+"' was mentioned.");
                        blnRes = false;
                }

                blnRes = compareValues(oBrowser, actual, expected);
            }
            return blnRes;
        }catch(Exception e){
            System.out.println("Exception in the method 'verifyText()': " + e);
            return false;
        }
        finally {
            oEle = null;
            oSelect = null;
            actual = null;
        }
    }


    /******************************************************************
     * Method Name      : verifyElementPresent()
     * purpose          :
     * Author           : sgTester1
     * Parameters       : oBrowser, strURL
     ******************************************************************/
    public boolean verifyElementPresent(WebDriver oBrowser, By objBy){
        List<WebElement> oEle = null;
        try{
            oEle = oBrowser.findElements(objBy);
            if(oEle.size()>0){
                System.out.println("The Element '"+objBy+"' exist in the DOM");
                return true;
            }else{
                System.out.println("The Element '"+objBy+"' Doesn't exist in the DOM");
                return false;
            }
        }catch(Exception e){
            System.out.println("Exception in the method 'verifyElementPresent()': " + e);
            return false;
        }
        finally {
            oEle = null;
        }
    }



    /******************************************************************
     * Method Name      : verifyElementNotPresent()
     * purpose          :
     * Author           : sgTester1
     * Parameters       : oBrowser, strURL
     ******************************************************************/
    public boolean verifyElementNotPresent(WebDriver oBrowser, By objBy){
        List<WebElement> oEle = null;
        try{
            oEle = oBrowser.findElements(objBy);
            if(oEle.size()>0){
                System.out.println("The Element '"+objBy+"' still exist in the DOM");
                return false;
            }else{
                System.out.println("The Element '"+objBy+"' removed from the DOM");
                return true;

            }
        }catch(Exception e){
            System.out.println("Exception in the method 'verifyElementNotPresent()': " + e);
            return false;
        }
        finally {
            oEle = null;
        }
    }



    /******************************************************************
     * Method Name      : getExcelData()
     * purpose          :
     * Author           : sgTester1
     * Parameters       : oBrowser, strURL
     ******************************************************************/
    public Map<String, String> getExcelData(String filePath, String sheetName, String logicalName){
        FileInputStream fin = null;
        Workbook wb = null;
        Sheet sh = null;
        Row row1 = null;
        Row row2 = null;
        Cell cell1 = null;
        Cell cell2 = null;
        String key = null;
        String value = null;
        Map<String, String> data = null;
        int rowNum = 0;
        int colNum = 0;
        String sDay = null;
        String sMonth = null;
        String sYear = null;
        Calendar cal = null;
        try{
            data = new HashMap<String, String>();
            fin = new FileInputStream(filePath);
            wb = new XSSFWorkbook(fin);
            sh = wb.getSheet(sheetName);
            if(sh==null){
                System.out.println("The sheet '"+sheetName+"' doesnot exist");
                return null;
            }

            //search the logical name
            boolean blnFlag = false;
            rowNum = sh.getPhysicalNumberOfRows();
            for(int r=0; r<rowNum; r++){
                row1 = sh.getRow(r);
                cell1 = row1.getCell(0);
                if(cell1.getStringCellValue().equalsIgnoreCase(logicalName)){
                    blnFlag = true;
                    rowNum = r;
                    break;
                }
            }

            //if logicalName exist, then read and key , constructo map
            if(blnFlag){
                row1 = sh.getRow(0);
                row2 = sh.getRow(rowNum);
                colNum = row1.getPhysicalNumberOfCells();
                for(int c=0; c<colNum; c++){
                    cell1 = row1.getCell(c);
                    key = cell1.getStringCellValue();
                    cell2 = row2.getCell(c);

                    //format the cell data
                    if(cell2==null|| cell2.getCellType()== CellType.BLANK){
                        value = "";
                    }else if(cell2.getCellType()==CellType.BOOLEAN){
                        value = String.valueOf(cell2.getBooleanCellValue());
                    }else if(cell2.getCellType()==CellType.STRING){
                        value = cell2.getStringCellValue();
                    }else if(cell2.getCellType()==CellType.NUMERIC){
                        if(DateUtil.isCellDateFormatted(cell2)==true){
                            double dt = cell2.getNumericCellValue();
                            cal = Calendar.getInstance();
                            cal.setTime(DateUtil.getJavaDate(dt));

                            //if day is <10, then prefix with zero
                            if(cal.get(Calendar.DAY_OF_MONTH) < 10){
                                sDay = "0" + cal.get(Calendar.DAY_OF_MONTH);
                            }else{
                                sDay = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
                            }

                            //if day is <10, then prefix with zero
                            if((cal.get(Calendar.MONTH)+1) < 10){
                                sMonth = "0" + (cal.get(Calendar.MONTH)+1);
                            }else{
                                sMonth = String.valueOf((cal.get(Calendar.MONTH)+1));
                            }

                            sYear = String.valueOf(cal.get(Calendar.YEAR));
                            value = sDay + "-" + sMonth + "-" + sYear;
                        }else{
                            value = String.valueOf(cell2.getNumericCellValue());
                        }
                    }
                    data.put(key, value);
                }
            }else{
                System.out.println("The logical name '"+logicalName+"' doesnot exist in the excel file");
                return null;
            }
            return data;
        }catch(Exception e){
            System.out.println("Exception in the method 'getExcelData()': " + e);
            return null;
        }finally {
            try{
                fin.close();
                fin = null;
                cell1 = null;
                cell2 = null;
                row1 = null;
                row2 = null;
                sh = null;
                wb.close();
                wb = null;
                cal = null;
            }catch(Exception e){
            }
        }
    }

}
