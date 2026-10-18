package utility;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//FeatureFile/selenium.feature",
	
		glue= "steps", 	
		dryRun=false,
		monochrome=false,
		plugin= {"pretty","html:C:\\Users\\lppaw\\Desktop\\BDD2026\\BDD2016Project\\Report/htmlreport.html","json:C:\\Users\\lppaw\\Desktop\\BDD2026\\BDD2016Project\\Report/jsonReport.json"},
		//plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/"}
		
		tags="@calendorHandling" 
		)





public class RunnerClass  {

}
