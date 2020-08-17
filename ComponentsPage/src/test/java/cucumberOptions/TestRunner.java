/**
 * 
 */
package cucumberOptions;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import managers.FileReaderManager;
import java.io.File;

/**
 * @author kowshic
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "src/test/java/features",
	glue="stepDefenitions",
	format = {"pretty", "html:target/CucumberReports"},
	plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/Extent Reports/report.html"})

public class TestRunner {
	
	 @AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
     Reporter.setSystemInfo("Machine", "Windows 10:-" + "64 Bit");
     Reporter.setSystemInfo("Maven", "3.5.2");
     Reporter.setSystemInfo("Java Version", "1.8.0_151");
     Reporter.assignAuthor("Kowshic");
	 }
}
