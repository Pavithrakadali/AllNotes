package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UtilityMethods {
    public WebDriver launchBrowser(){
        WebDriver oDriver = null;
        try{
            oDriver = new ChromeDriver();
            oDriver.manage().window().maximize();
            return oDriver;
        }catch(Exception e){
            System.out.println("Exception in 'launchBrowser()' method. " + e);
            return null;
        }
    }


    public boolean navigateURL(WebDriver oBrowser, String strURL){
        try{
            oBrowser.navigate().to(strURL);
            Thread.sleep(2000);
            if(oBrowser.getTitle().equalsIgnoreCase("actiTIME - Login")){
                System.out.println("The url loaded successful");
                return true;
            }else{
                System.out.println("Failed to load the url");
                return false;
            }
        }catch(Exception e){
            System.out.println("Exception in 'navigateURL()' method. " + e);
            return false;
        }
    }
}
