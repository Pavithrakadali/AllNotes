package baseClass;

import driver.CucumberTestRunner;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.an.E;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class LoginBaseClass extends CucumberTestRunner {
    public boolean verifyLaunchBrowser(){
        oBrowser = appInd.launchBrowser("Chrome");
        if(oBrowser!=null){
            reports.writeReport(oBrowser, "Pass", "The browser launched successful");
            return true;
        }else{
            reports.writeReport(oBrowser, "Fail", "Failed to launch the browser");
            return false;
        }
    }


    public boolean verifyNavigateURL(WebDriver oBrowser, DataTable dataTable){
        List<Map<String, String>> inputData = null;
        try{
            inputData = dataTable.asMaps(String.class, String.class);
            return appDep.navigateURL(oBrowser, inputData.get(0).get("appURL"));
        }catch(Exception e){
            reports.writeReport(oBrowser, "Exception", "Exception in the method 'verifyNavigateURL()': " + e);
            return false;
        }
    }


    public boolean verifyLoginToActiTimeFunctionality(WebDriver oBrowser, DataTable dataTable){
        List<Map<String, String>> inputData = null;
        try{
            inputData = dataTable.asMaps(String.class, String.class);
            return appDep.loginToApplication(oBrowser, inputData.get(0).get("userName"), inputData.get(0).get("password"));
        }catch(Exception e){
            reports.writeReport(oBrowser, "Exception", "Exception in the method 'verifyLoginToActiTimeFunctionality()': " + e);
            return false;
        }
    }
}
