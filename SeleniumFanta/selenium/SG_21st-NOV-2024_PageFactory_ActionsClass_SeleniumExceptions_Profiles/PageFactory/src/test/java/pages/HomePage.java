package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver oBrowser;

    public HomePage(WebDriver oBrowser){
        PageFactory.initElements(oBrowser, this);
    }

    @FindBy(xpath = "//a[@id='logoutLink']")
    private WebElement obj_Logout_Link;

    public WebElement getLogoutLink(){
        return obj_Logout_Link;
    }

    public boolean logoutFromApp(WebDriver oBrowser){
        LoginPage login = null;
        try{
            getLogoutLink().click();
            Thread.sleep(2000);
            login = new LoginPage(oBrowser);
            if(login.verifyLoginPageHeader(oBrowser, "Please identify yourself")){
                System.out.println("Logout from the application was successful");
                return true;
            }else{
                System.out.println("Failed to Logout from the application");
                return false;
            }
        }catch(Exception e){
            System.out.println("Exception in 'logoutFromApp()' method. " + e);
            return false;
        }finally {
            login = null;
        }
    }
}
