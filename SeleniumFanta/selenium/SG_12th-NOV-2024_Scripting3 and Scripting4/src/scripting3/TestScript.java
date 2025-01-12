package scripting3;

import org.openqa.selenium.WebDriver;

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
        try{
            oBrowser = launchBrowser("Edge");
            if(oBrowser!=null){
                navigateURL(oBrowser, "http://localhost/login.do");
                loginToApplication(oBrowser, "admin", "manager");
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
        }
    }



    public void testScript2(){
        WebDriver oBrowser = null;
        String userName = null;
        try{
            oBrowser = launchBrowser("Chrome");
            if(oBrowser!=null){
                navigateURL(oBrowser, "http://localhost/login.do");
                loginToApplication(oBrowser, "admin", "manager");
                userName = createUser(oBrowser);
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
        }
    }
}
