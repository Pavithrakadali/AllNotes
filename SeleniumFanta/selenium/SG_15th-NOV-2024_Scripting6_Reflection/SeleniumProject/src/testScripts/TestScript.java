package testScripts;

import methods.AppDependentMethod;
import org.openqa.selenium.WebDriver;
import java.util.Map;

public class TestScript extends AppDependentMethod {
    public void testScript1(){
        WebDriver oBrowser = null;
        String userName = null;
        Map<String, String> data = null;
        try{
            data = getExcelData(System.getProperty("user.dir")+"\\TestData\\TestData.xlsx", "testData", "TS_001");

            oBrowser = launchBrowser(data.get("browserName"));
            if(oBrowser!=null){
                navigateURL(oBrowser, data.get("appURL"));
                loginToApplication(oBrowser, data.get("userName"), data.get("password"));
                logoutFromApplication(oBrowser);
            }else{
                System.out.println("Failed to launch the browser");
            }
        }catch(Exception e){
            System.out.println("Exception in the 'testScript1()' script. " + e);
        }finally {
            userName = null;
            oBrowser.close();
            oBrowser = null;
            data = null;
        }
    }



    public void testScript2(){
        WebDriver oBrowser = null;
        String userName = null;
        Map<String, String> data = null;
        try{
            data = getExcelData(System.getProperty("user.dir")+"\\TestData\\TestData.xlsx", "testData", "TS_002");
            oBrowser = launchBrowser(data.get("browserName"));
            if(oBrowser!=null){
                navigateURL(oBrowser, data.get("appURL"));
                loginToApplication(oBrowser, data.get("userName"), data.get("password"));
                userName = createUser(oBrowser, data);
                deleteUser(oBrowser, userName);
                logoutFromApplication(oBrowser);
            }else{
                System.out.println("Failed to launch the browser");
            }
        }catch(Exception e){
            System.out.println("Exception in the 'testScript2()' script. " + e);
        }finally {
            oBrowser.close();
            oBrowser = null;
            data = null;
        }
    }


    public void testScript3(){
        WebDriver oBrowser = null;
        String userName = null;
        Map<String, String> data = null;
        try{
            data = getExcelData(System.getProperty("user.dir")+"\\TestData\\TestData.xlsx", "testData", "TS_003");
            oBrowser = launchBrowser(data.get("browserName"));
            if(oBrowser!=null){
                navigateURL(oBrowser, data.get("appURL"));
                loginToApplication(oBrowser, data.get("userName"), data.get("password"));
                userName = createUserProp(oBrowser, data);
                deleteUser(oBrowser, userName);
                logoutFromApplication(oBrowser);
            }else{
                System.out.println("Failed to launch the browser");
            }
        }catch(Exception e){
            System.out.println("Exception in the 'testScript3()' script. " + e);
        }finally {
            oBrowser.close();
            oBrowser = null;
            data = null;
        }
    }
}
