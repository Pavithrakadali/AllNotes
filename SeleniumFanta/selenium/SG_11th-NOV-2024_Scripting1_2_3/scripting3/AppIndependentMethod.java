package scripting3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AppIndependentMethod {
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
}
