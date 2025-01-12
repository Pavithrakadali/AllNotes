package driver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import common.AppDependentMethod;
import common.AppIndependentMethod;
import common.ReportUtils;
import org.testng.annotations.BeforeSuite;
import java.util.Map;

public class CucumberTestRunner {
    public static AppIndependentMethod appInd = null;
    public static AppDependentMethod appDep = null;
    public static ReportUtils reports = null;
    public static ExtentReports extent = null;
    public static ExtentTest test = null;
    public static String screenshotDir = null;
    public static Map<String, String> propData = null;


    @BeforeSuite
    public void loadClasses(){

        try{
            appInd = new AppIndependentMethod();
            appDep = new AppDependentMethod();
            reports = new ReportUtils();
            propData = appInd.getPropDetails(System.getProperty("user.dir")+"/src/main/resources/config.properties");
            extent = reports.startExtentReport("TestResults");


        }catch(Exception e){
            System.out.println("Exception in 'loadClasses()' method. " + e);
        }
    }
}
