package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
    WebDriver oBrowser;
    public LoginPage(WebDriver oBrowser){
        PageFactory.initElements(oBrowser, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement obj_UserName_Edit;

    @FindBy(xpath = "//input[@name='pwd']")
    private WebElement obj_Password_Edit;

    @FindBy(css = "a[id='loginButton']")
    private WebElement obj_Login_Link;

    @FindBy(id = "headerContainer")
    private WebElement obj_LoginPage_Header;

    @FindBy(xpath = "//img[contains(@src,'/timer.png')]")
    private WebElement obj_LoginPage_Logo_Image;

    @FindBy(xpath = "//td[@class='pagetitle']")
    private WebElement obj_Homepage_Header;


    //Getter approach to access the private members
    public WebElement getUserName(){
        return obj_UserName_Edit;
    }

    public WebElement getPassword(){
        return obj_Password_Edit;
    }

    public WebElement getLoginButton(){
        return obj_Login_Link;
    }

    public WebElement getLoginPageHeader(){
        return obj_LoginPage_Header;
    }

    public WebElement getLoginPageLogo(){
        return obj_LoginPage_Logo_Image;
    }

    public WebElement getHomePageHeader(){
        return obj_Homepage_Header;
    }




    public boolean verifyLoginPageLogo(WebDriver oBrowser){
//        if(oBrowser.findElement(obj_LoginPage_Logo_Image).isDisplayed()){
//            System.out.println("The login Page logo was displayed successful");
//            return true;
//        }else{
//            System.out.println("Failed to displayed the valid login Page logo");
//            return false;
//        }
        Assert.assertTrue(getLoginPageLogo().isDisplayed(), "Failed to display the login page logo image");
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
        Assert.assertEquals(getLoginPageHeader().getText(), headerText, "Mis-match in actual and expected values");
        return true;
    }

    public boolean loginToApp(WebDriver oBrowser, String userName, String password){
        try{
            getUserName().sendKeys(userName);
            getPassword().sendKeys(password);
            getLoginButton().click();
            Thread.sleep(2000);
            if(getHomePageHeader().getText().equalsIgnoreCase("Enter Time-Track")){
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
