package scripting4_PropFile;

import org.openqa.selenium.WebDriver;

import java.util.Map;

public class TestScript extends AppDependentMethod {
    public static void main(String[] args) {
        TestScript script = new TestScript();

        script.testScript1();
        System.out.println("*******************************************************");
        script.testScript2();
    }


    public void testScript1(){
        WebDriver oBrowser = null;
        String userName = null;
        Map<String, String> data = null;
        try{
            data = getPropData(System.getProperty("user.dir")+"\\TestData\\TestData.properties");
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
            data = getPropData(System.getProperty("user.dir")+"\\TestData\\TestData.properties");
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
            System.out.println("Exception in the 'testScript1()' script. " + e);
        }finally {
            oBrowser.close();
            oBrowser = null;
            data = null;
        }
    }
}
