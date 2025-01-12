package locators;

import org.openqa.selenium.By;

public interface ObjectMapping {
    By obj_UserName_Edit = By.id("username");
    By obj_Password_Edit = By.name("pwd");
    By obj_Login_Btn = By.id("loginButton");
    By obj_SaveChanges_Btn = By.xpath("//span/input[@value='Save Changes']");
    By obj_ShortCut_Close_Btn = By.id("gettingStartedShortcutsMenuCloseId");
    By obj_USERS_Menu = By.xpath("//div[text()='USERS']");
    By obj_AddUsers_Btn = By.xpath("//div[text()='Add User']");
    By obj_User_FirstName_Edit = By.xpath("//input[@name='firstName']");
    By obj_User_LastName_Edit = By.xpath("//input[@name='lastName']");
    By obj_User_Email_Edit = By.xpath("//input[@name='email']");
    By obj_User_UserName_Edit = By.xpath("//input[@name='username']");
    By obj_User_Password_Edit = By.xpath("//input[@name='password']");
    By obj_User_RetypePassword_Edit = By.xpath("//input[@name='passwordCopy']");
    By obj_CreateUser_Btn = By.xpath("//span[text()='Create User']");
    By obj_DeleteUser_Btn = By.xpath("//button[contains(text(), 'Delete User')]");
    By obj_Logout_Link = By.xpath("//a[@id='logoutLink']");
    By obj_LoginHeader_Label = By.id("headerContainer");
    String obj_userName_Link = "//div[@class='name']/span[text()='%s']";
}
