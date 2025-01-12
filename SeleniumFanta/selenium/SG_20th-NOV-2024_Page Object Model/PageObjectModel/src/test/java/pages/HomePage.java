package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver oBrowser;

    public HomePage(WebDriver oBrowser){
        this.oBrowser = oBrowser;
    }
    public By obj_Logout_Link = By.xpath("//a[@id='logoutLink']");

    public boolean logoutFromApp(WebDriver oBrowser){
        LoginPage login = null;
        try{
            oBrowser.findElement(obj_Logout_Link).click();
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
