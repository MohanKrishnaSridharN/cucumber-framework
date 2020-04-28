package stepDefs;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import pageobjects.BaseTest;

@ExtendedCucumberOptions(
		jsonReport = "target/cucumber.json",
        retryCount = 3,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        coverageReport = true,
        jsonUsageReport = "target/cucumber-usage.json",
        usageReport = true,
        toPDF = true,
        excludeCoverageTags = {"@flaky" },
        includeCoverageTags = {"@passed" },
        outputFolder = "target")
@CucumberOptions(
		monochrome = true,
		dryRun = false,
		
		//tags = {"@Important"},				//Important features
		//tags = {"@Debug"},					//Only Debug
		tags = {"@Smoke"},						//Only Smok
		//tags = {"@Regression"},
		//tags = {"@Smoke", "@Regression"}, 	//And condition
		//tags = {"@Smoke, @Regression"},			//Or Condition
		//tags = {"@ParallelTestingwithCucumber"},
		features = {"src/test/java/features"},	
		glue = { "stepDefs"},
		
		plugin = { //"pretty", 
				//"html:target/cucumber-htmlreport", 
				//"json:target/cucumber-report.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport.html",
				"html:target/cucumber-html-report",
		        "json:target/cucumber.json",
		        //"pretty:target/cucumber-pretty.txt",
		        //"usage:target/cucumber-usage.json",
		        //"junit:target/cucumber-results.xml"
				}
		)

public class TestRunnerBase extends BaseTest {
    private TestNGCucumberRunner testNGCucumberRunner;
    
 
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
 
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
    
}