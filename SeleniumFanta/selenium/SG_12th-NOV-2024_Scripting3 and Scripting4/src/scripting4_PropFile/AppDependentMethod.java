package scripting4_PropFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class AppDependentMethod extends AppIndependentMethod {
    /******************************************************************
     * Method Name      : navigateURL()
     * purpose          :
     * Author           : sgTester1
     * Reviewed By      : sgTester2
     * Parameters       : oBrowser, strURL
     ******************************************************************/
    public boolean navigateURL(WebDriver oBrowser, String strURL){
        try{
            oBrowser.navigate().to(strURL);
            Thread.sleep(2000);

            return compareValues(oBrowser, oBrowser.getTitle(), "actiTIME - Login");
        }catch(Exception e){
            System.out.println("Exception in the method 'navigateURL()': " + e);
            return false;
        }
    }


    /******************************************************************
     * Method Name      : loginToApplication()
     * purpose          :
     * Author           : sgTester1
     * Reviewed By      : sgTester2
     * Parameters       : oBrowser, strURL
     ******************************************************************/
    public boolean loginToApplication(WebDriver oBrowser, String userName, String password){
        try{
            setObject(oBrowser, By.id("username"), userName);
            setObject(oBrowser, By.name("pwd"), password);
            clickObject(oBrowser, By.id("loginButton"));
            Thread.sleep(2000);

            boolean blnRes = verifyText(oBrowser, By.xpath("//span/input[@value='Save Changes']"), "value", "Save Changes");
            if(blnRes) {
                clickObject(oBrowser, By.id("gettingStartedShortcutsMenuCloseId"));
                return true;
            }
            else return false;

        }catch(Exception e){
            System.out.println("Exception in the method 'loginToApplication()': " + e);
            return false;
        }
    }


    /******************************************************************
     * Method Name      : createUser()
     * purpose          :
     * Author           : sgTester1
     * Reviewed By      : sgTester2
     * Parameters       : oBrowser, strURL
     ******************************************************************/
    public String createUser(WebDriver oBrowser, Map<String, String> data){
        String userName = null;
        try{
            clickObject(oBrowser, By.xpath("//div[text()='USERS']"));
            Thread.sleep(2000);
            clickObject(oBrowser, By.xpath("//div[text()='Add User']"));
            Thread.sleep(2000);

            setObject(oBrowser, By.xpath("//input[@name='firstName']"), data.get("user_firstName"));
            setObject(oBrowser, By.xpath("//input[@name='lastName']"), data.get("user_lastName"));
            setObject(oBrowser, By.xpath("//input[@name='email']"), data.get("user_email"));
            setObject(oBrowser, By.xpath("//input[@name='username']"), data.get("user_userName"));
            setObject(oBrowser, By.xpath("//input[@name='password']"), data.get("user_password"));
            setObject(oBrowser, By.xpath("//input[@name='passwordCopy']"), data.get("user_retypePassword"));

            clickObject(oBrowser, By.xpath("//span[text()='Create User']"));
            Thread.sleep(2000);
            userName = data.get("user_lastName") + ", "+data.get("user_firstName");
            boolean blnRes = verifyElementPresent(oBrowser, By.xpath("//div[@class='name']/span[text()='"+userName+"']"));
            if(blnRes){
                System.out.println("The new user '"+userName+"' was created successful");
                return userName;
            }else{
                System.out.println("Failed to create the new user");
                return null;
            }
        }catch(Exception e){
            System.out.println("Exception in the method 'createUser()': " + e);
            return null;
        }finally {
            userName = null;
        }
    }


    /******************************************************************
     * Method Name      : deleteUser()
     * purpose          :
     * Author           : sgTester1
     * Reviewed By      : sgTester2
     * Parameters       : oBrowser, strURL
     ******************************************************************/
    public boolean deleteUser(WebDriver oBrowser, String userName){
        try{
            clickObject(oBrowser, By.xpath("//div[@class='name']/span[text()='"+userName+"']"));
            Thread.sleep(2000);
            clickObject(oBrowser, By.xpath("//button[contains(text(), 'Delete User')]"));
            Thread.sleep(2000);
            oBrowser.switchTo().alert().accept();
            Thread.sleep(2000);

            return verifyElementNotPresent(oBrowser, By.xpath("//div[@class='name']/span[text()='"+userName+"']"));
        }catch(Exception e){
            System.out.println("Exception in the method 'deleteUser()': " + e);
            return false;
        }
    }



    /******************************************************************
     * Method Name      : logoutFromApplication()
     * purpose          :
     * Author           : sgTester1
     * Reviewed By      : sgTester2
     * Parameters       : oBrowser, strURL
     ******************************************************************/
    public boolean logoutFromApplication(WebDriver oBrowser){
        try{
            clickObject(oBrowser, By.xpath("//a[@id='logoutLink']"));
            Thread.sleep(2000);

            return verifyText(oBrowser, By.id("headerContainer"), "Text", "Please identify yourself");
        }catch(Exception e){
            System.out.println("Exception in the method 'logoutFromApplication()': " + e);
            return false;
        }
    }
}
