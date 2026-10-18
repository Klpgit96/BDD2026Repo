package steps;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

import basepackage.BaseClass;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.SelPOM;

public class SeleniumSteps {
    public WebDriver driver;
	public BaseClass base;
	public SelPOM sel;
	
	@Given("user launch demoqa browser")
	public void user_launch_demoqa_browser() {
	 //  WebDriverManager.edgedriver().setup();
	   driver = new EdgeDriver();
	   driver.manage().window().maximize();
	   sel = new SelPOM(driver);
	   base= new BaseClass(driver);
		
	}

	@When("enter demoqa url {string}")
	public void enter_demoqa_url(String url) {
	    driver.get(url);
	}

	@When("go to alert page")
	public void go_to_alert_page() {
	    sel.clickon_alertframewindwcard();
	}

	@When("click on simple alert clickon button")
	public void click_on_simple_alert_clickon_button() {
	    sel.clickOnsimplealertButton();
	}

	@Then("simple alert should be open")
	public void simple_alert_should_be_open() {
	  sel.simplealertValidate();
	}

	@Then("close alert")
	public void close_alert() {
	    sel.alertAccept();
	}

	@Then("close browser")
	public void close_browser() {
	  System.out.println("close browser");
	  driver.close();
	   driver.quit();
	}

//	@AfterStep()
//public void capturescreenshot(Scenario scenario) {
//	//base.captureScreenshot(scenario);
//
//	TakesScreenshot scr = ((TakesScreenshot) driver);
//final byte[] source = scr.getScreenshotAs(OutputType.BYTES);
//	
//	scenario.attach(source, "image/png",scenario.getName() );
//	
//}
	
	@When("click on Timer alert clickon button")
	public void click_on_timer_alert_clickon_button() {
	   sel.clickOntimerAlertButton();
	}
	
	@Then("handle timer alert")
	public void handle_timer_alert() {
	    sel.handletimerAlertButton();
	}


	@When("click on prompt alert clickon button")
	public void click_on_prompt_alert_clickon_button() {
	   sel.clickonpromptbutton();
		
	}

	@Then("handle prompt alert sendkeys with accept")
	public void handle_prompt_alert_sendkeys_with_accept() {
	   sel.HandlepromtAlertWithAccept();
		
	}
	

	@Then("handle prompt alert sendkeys with dissmiss")
	public void handle_prompt_alert_sendkeys_with_dissmiss() {
sel.HandlepromtAlertWithDismiss();

	}

//multiple window handling
	@When("click on newTabsWindowsBtn")
	public void click_on_new_tabs_windows_btn() {
	    sel.clickonnewTabsWindowsBtn();
	}

	@Then("switch to secnd window and handle it")
	public void switch_to_secnd_window_and_handle_it() {
	    sel.handlemultipleWindow();
	}

	//iframe handling
	
	@When("switch to first iframe and return back to main page")
	public void switch_to_first_iframe_and_return_back_to_main_page() {
	    try {
			sel.validateFirstiframe();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("switch to secnd iframe and andle a child frame and return back to main page")
	public void switch_to_secnd_iframe_and_andle_a_child_frame_and_return_back_to_main_page() {
	    System.out.println("--------------------------------------------------");
	    sel.validateNestedIfrane();
	}
	
	//calendor handling
	
	@When("handle first date as a current date")
	public void handle_first_date_as_a_current_date() {
	   sel.selectCurrentDate();
	}

	@When("handle second calendor as future date")
	public void handle_second_calendor_as_future_date() {
	    System.out.println("--------------------------------------------------");
	}

	@Then("handle Third calendor as past date")
	public void handle_third_calendor_as_past_date() {
	    System.out.println("--------------------------------------------------"); 
	}

	
	
	
	
	
	
	
	
}
