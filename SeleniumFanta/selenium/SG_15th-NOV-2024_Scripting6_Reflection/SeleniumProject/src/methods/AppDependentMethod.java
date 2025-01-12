package methods;

import locators.ObjectMapping;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class AppDependentMethod extends AppIndependentMethod implements ObjectMapping {
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
            setObject(oBrowser, obj_UserName_Edit, userName);
            setObject(oBrowser, obj_Password_Edit, password);
            clickObject(oBrowser, obj_Login_Btn);
            Thread.sleep(2000);

            boolean blnRes = verifyText(oBrowser, obj_SaveChanges_Btn, "value", "Save Changes");
            if(blnRes) {
                clickObject(oBrowser, obj_ShortCut_Close_Btn);
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
            clickObject(oBrowser, obj_USERS_Menu);
            Thread.sleep(2000);
            clickObject(oBrowser, obj_AddUsers_Btn);
            Thread.sleep(2000);

            setObject(oBrowser, obj_User_FirstName_Edit, data.get("user_firstName"));
            setObject(oBrowser, obj_User_LastName_Edit, data.get("user_lastName"));
            setObject(oBrowser, obj_User_Email_Edit, data.get("user_email"));
            setObject(oBrowser, obj_User_UserName_Edit, data.get("user_userName"));
            setObject(oBrowser, obj_User_Password_Edit, data.get("user_password"));
            setObject(oBrowser, obj_User_RetypePassword_Edit, data.get("user_retypePassword"));

            clickObject(oBrowser, obj_CreateUser_Btn);
            Thread.sleep(2000);
            userName = data.get("user_lastName") + ", "+data.get("user_firstName");
            boolean blnRes = verifyElementPresent(oBrowser, By.xpath(String.format(obj_userName_Link, userName)));
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
     * Method Name      : createUser()
     * purpose          :
     * Author           : sgTester1
     * Reviewed By      : sgTester2
     * Parameters       : oBrowser, strURL
     ******************************************************************/
    public String createUserProp(WebDriver oBrowser, Map<String, String> data){
        String userName = null;
        try{
            clickObject(oBrowser, createAndReturnBy(getPropValueByKey("obj_USERS_Menu")));
            Thread.sleep(2000);
            clickObject(oBrowser, createAndReturnBy(getPropValueByKey("obj_AddUsers_Btn")));
            Thread.sleep(2000);

            setObject(oBrowser, createAndReturnBy(getPropValueByKey("obj_User_FirstName_Edit")), data.get("user_firstName"));
            setObject(oBrowser, createAndReturnBy(getPropValueByKey("obj_User_LastName_Edit")), data.get("user_lastName"));
            setObject(oBrowser, createAndReturnBy(getPropValueByKey("obj_User_Email_Edit")), data.get("user_email"));
            setObject(oBrowser, createAndReturnBy(getPropValueByKey("obj_User_UserName_Edit")), data.get("user_userName"));
            setObject(oBrowser, createAndReturnBy(getPropValueByKey("obj_User_Password_Edit")), data.get("user_password"));
            setObject(oBrowser, createAndReturnBy(getPropValueByKey("obj_User_RetypePassword_Edit")), data.get("user_retypePassword"));

            clickObject(oBrowser, createAndReturnBy(getPropValueByKey("obj_CreateUser_Btn")));
            Thread.sleep(2000);
            userName = data.get("user_lastName") + ", "+data.get("user_firstName");
            boolean blnRes = verifyElementPresent(oBrowser, By.xpath(String.format(obj_userName_Link, userName)));
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
            clickObject(oBrowser, By.xpath(String.format(obj_userName_Link, userName)));
            Thread.sleep(2000);
            clickObject(oBrowser, obj_DeleteUser_Btn);
            Thread.sleep(2000);
            oBrowser.switchTo().alert().accept();
            Thread.sleep(2000);

            return verifyElementNotPresent(oBrowser, By.xpath(String.format(obj_userName_Link, userName)));
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
            clickObject(oBrowser, obj_Logout_Link);
            Thread.sleep(2000);

            return verifyText(oBrowser, obj_LoginHeader_Label, "Text", "Please identify yourself");
        }catch(Exception e){
            System.out.println("Exception in the method 'logoutFromApplication()': " + e);
            return false;
        }
    }
}
