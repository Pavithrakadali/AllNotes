package stepDefinition;

import driver.CucumberTestRunner;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class LoginStepDefinition extends CucumberTestRunner {

    @Given("verify user navigates the URL")
    public void verifyUserNavigatesTheURL(DataTable dataTable) {
        Assert.assertTrue(loginBaseClass.verifyNavigateURL(oBrowser, dataTable));
    }

    @And("verify user enters valid credentials")
    public void verifyUserEntersValidCredentials(DataTable dataTable) {
        Assert.assertTrue(loginBaseClass.verifyLoginToActiTimeFunctionality(oBrowser, dataTable));
    }

    @And("verify user logout from the application")
    public void verifyUserLogoutFromTheApplication() {
        Assert.assertTrue(appDep.logoutFromApplication(oBrowser));
    }
}
