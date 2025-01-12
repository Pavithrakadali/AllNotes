package scripting3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppDependentMethod {

    /******************************************************************
     * Method Name      : launchBrowser()
     * purpose          : This method launches the browsers based on input
     *                  : supported browsers: Chrome, Firefox and Edge
     * Author           : sgTester1
     * Reviewed By      : sgTester2
     * Parameters       : browserName
     ******************************************************************/
    public WebDriver launchBrowser(String browserName){
        WebDriver oDriver = null;
        try{
            switch(browserName.toLowerCase()){
                case "chrome":
                    oDriver = new ChromeDriver();
                    break;
                case "firefox":
                    oDriver = new FirefoxDriver();
                    break;
                case "edge":
                    oDriver = new EdgeDriver();
                    break;
                default:
                    System.out.println("Invalid '"+browserName+"' browser name was mentioned. Please specified valid broswer name");
                    return null;
            }
            if(oDriver==null){
                System.out.println("Failed to launch '"+browserName+"' browser");
                return null;
            }else{
                System.out.println("The '"+browserName+"' browser is launched successful");
                oDriver.manage().window().maximize();
                return oDriver;
            }
        }catch(Exception e){
            System.out.println("Exception in the method 'launchBrowser()': " + e);
            return null;
        }
    }



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
            if(oBrowser.getTitle().equalsIgnoreCase("actiTIME - Login")){
                System.out.println("The URL '"+strURL+"' navigated successful");
                return true;
            }else{
                System.out.println("Failed to navigate the URL '"+strURL+"'");
                return false;
            }
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
            oBrowser.findElement(By.id("username")).sendKeys(userName);
            oBrowser.findElement(By.name("pwd")).sendKeys(password);
            oBrowser.findElement(By.id("loginButton")).click();
            Thread.sleep(2000);

            if(oBrowser.findElement(By.xpath("//span/input[@value='Save Changes']")).getAttribute("value").equalsIgnoreCase("Save Changes")){
                System.out.println("Login to application was successful");
                oBrowser.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
                return true;
            }else{
                System.out.println("Failed to login to the application");
                return false;
            }
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
    public String createUser(WebDriver oBrowser){
        String userName = null;
        try{
            oBrowser.findElement(By.xpath("//div[text()='USERS']")).click();
            Thread.sleep(2000);

            oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
            Thread.sleep(2000);

            oBrowser.findElement(By.xpath("//input[@name='firstName']")).sendKeys("sg");
            oBrowser.findElement(By.xpath("//input[@name='lastName']")).sendKeys("tester");
            oBrowser.findElement(By.xpath("//input[@name='email']")).sendKeys("sg.tester@sg.com");
            oBrowser.findElement(By.xpath("//input[@name='username']")).sendKeys("sgtester");
            oBrowser.findElement(By.xpath("//input[@name='password']")).sendKeys("Mercury@1");
            oBrowser.findElement(By.xpath("//input[@name='passwordCopy']")).sendKeys("Mercury@1");

            oBrowser.findElement(By.xpath("//span[text()='Create User']")).click();
            Thread.sleep(2000);
            userName = "tester, sg";
            if(oBrowser.findElement(By.xpath("//div[@class='name']/span[text()='"+userName+"']")).isDisplayed()){
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
            oBrowser.findElement(By.xpath("//div[@class='name']/span[text()='"+userName+"']")).click();
            Thread.sleep(2000);

            oBrowser.findElement(By.xpath("//button[contains(text(), 'Delete User')]")).click();
            Thread.sleep(2000);
            oBrowser.switchTo().alert().accept();
            Thread.sleep(2000);

            if(oBrowser.findElements(By.xpath("//div[@class='name']/span[text()='"+userName+"']")).size() > 0){
                System.out.println("Failed to delete the user '"+userName+"'");
                return false;
            }else{
                System.out.println("The user '"+userName+"' was deleted successful");
                return true;
            }
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
            oBrowser.findElement(By.xpath("//a[@id='logoutLink']")).click();
            Thread.sleep(2000);

            if(oBrowser.findElement(By.id("headerContainer")).getText().equalsIgnoreCase("Please identify yourself")){
                System.out.println("Logout from application is successful");
                return true;
            }else{
                System.out.println("Failed to logout from the application");
                return false;
            }
        }catch(Exception e){
            System.out.println("Exception in the method 'logoutFromApplication()': " + e);
            return false;
        }
    }
}
