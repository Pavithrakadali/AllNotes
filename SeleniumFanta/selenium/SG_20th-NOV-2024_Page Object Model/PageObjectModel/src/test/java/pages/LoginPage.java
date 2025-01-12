package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    WebDriver oBrowser;
    public LoginPage(WebDriver oBrowser){
        this.oBrowser = oBrowser;
    }

    public By obj_UserName_Edit = By.xpath("//input[@id='username']");
    public By obj_Password_Edit = By.xpath("//input[@name='pwd']");
    public By obj_Login_Link = By.xpath("//a[@id='loginButton']");
    public By obj_LoginPage_Header = By.id("headerContainer");
    public By obj_LoginPage_Logo_Image = By.xpath("//img[contains(@src,'/timer.png')]");
    public By obj_Homepage_Header = By.xpath("//td[@class='pagetitle']");

    public boolean verifyLoginPageLogo(WebDriver oBrowser){
//        if(oBrowser.findElement(obj_LoginPage_Logo_Image).isDisplayed()){
//            System.out.println("The login Page logo was displayed successful");
//            return true;
//        }else{
//            System.out.println("Failed to displayed the valid login Page logo");
//            return false;
//        }
        Assert.assertTrue(oBrowser.findElement(obj_LoginPage_Logo_Image).isDisplayed(), "Failed to display the login page logo image");
        return true;
    }

    public boolean verifyLoginPageHeader(WebDriver oBrowser, String headerText){
//        if(oBrowser.findElement(obj_LoginPage_Header).getText().equalsIgnoreCase(headerText)){
//            System.out.println("The login Page Header was displayed successful");
//            return true;
//        }else{
//            System.out.println("Failed to displayed the valid login Page Header");
//            return false;
//        }
        Assert.assertEquals(oBrowser.findElement(obj_LoginPage_Header).getText(), headerText, "Mis-match in actual and expected values");
        return true;
    }

    public boolean loginToApp(WebDriver oBrowser, String userName, String password){
        try{
            oBrowser.findElement(obj_UserName_Edit).sendKeys(userName);
            oBrowser.findElement(obj_Password_Edit).sendKeys(password);
            oBrowser.findElement(obj_Login_Link).click();
            Thread.sleep(2000);
            if(oBrowser.findElement(obj_Homepage_Header).getText().equalsIgnoreCase("Enter Time-Track")){
                System.out.println("Login to actiTime was successful");
                return true;
            }else{
                System.out.println("Failed to Login to actiTime");
                return false;
            }
        }catch(Exception e){
            System.out.println("Exception in 'loginToApp()' method. " +e);
            return false;
        }
    }
}
