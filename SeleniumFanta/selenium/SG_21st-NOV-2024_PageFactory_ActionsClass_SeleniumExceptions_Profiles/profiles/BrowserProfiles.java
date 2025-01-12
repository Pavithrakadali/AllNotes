package profiles;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserProfiles {
    public static void main(String args[])
    {
        WebDriver oBrowser = null;
        try {
            ChromeOptions options = new ChromeOptions();
            //disable notifications
            options.addArguments("--disable-notifications");

            //maximize the browser
            options.addArguments("--start-maximized");

            //disable info bar
            //options.addArguments("disable-infobars");
            options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});

            //to open in incognito mode
            options.addArguments("-incognito");

            //disable popup blocker
            options.addArguments("--disable-popup-blocking");


            //Disable web secutiry & proxy server
            options.addArguments("--disable-web-security");
            options.addArguments("--no-proxy-server");


            //Disable save password window
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            oBrowser = new ChromeDriver(options);
            oBrowser.manage().window().maximize();
            oBrowser.get("https://www.redbus.in/");
            Thread.sleep(2000);
        }catch(Exception e)
        {
            System.out.println(e);
        }
        finally {
            oBrowser = null;
        }
    }
}
