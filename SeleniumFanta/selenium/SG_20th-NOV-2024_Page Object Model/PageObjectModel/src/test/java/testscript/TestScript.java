package testscript;

import methods.UtilityMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class TestScript {
    UtilityMethods methods = null;
    WebDriver oBrowser = null;
    LoginPage loginPage = null;
    HomePage home = null;

    @BeforeClass
    public void loadClasses(){
        methods = new UtilityMethods();
        oBrowser = methods.launchBrowser();
        loginPage = new LoginPage(oBrowser);
        home = new HomePage(oBrowser);
    }


    @Test
    public void TC_LoginLogout1(){
        try{
            methods.navigateURL(oBrowser, "http://localhost/login.do");
            Assert.assertTrue(loginPage.verifyLoginPageHeader(oBrowser, "Please identify yourself"));
            Assert.assertTrue(loginPage.verifyLoginPageLogo(oBrowser));
            Assert.assertTrue(loginPage.loginToApp(oBrowser, "admin", "manager"));
            Assert.assertTrue(home.logoutFromApp(oBrowser));
        }catch(Exception e){
            System.out.println("Exception in 'TC_LoginLogout1()' testScript. " + e);
        }
    }

    @Test
    public void TC_LoginLogout2(){
        try{
            methods.navigateURL(oBrowser, "http://localhost/login.do");
            Assert.assertTrue(loginPage.verifyLoginPageHeader(oBrowser, "Please identify yourself"));
            Assert.assertTrue(loginPage.verifyLoginPageLogo(oBrowser));
            Assert.assertTrue(loginPage.loginToApp(oBrowser, "admin", "manager"));
            Assert.assertTrue(home.logoutFromApp(oBrowser));
        }catch(Exception e){
            System.out.println("Exception in 'TC_LoginLogout2()' testScript. " + e);
        }
    }

    @AfterClass
    public void tearDown(){
        oBrowser.close();
        oBrowser = null;
    }
}
