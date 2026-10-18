package basepackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.messages.types.Scenario;

public class BaseClass {
	public WebDriver driver;

	public BaseClass(WebDriver ldriver) {
		driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}

	public void captureScreenshot(Scenario scenario) throws IOException {

		TakesScreenshot scr = ((TakesScreenshot) driver);
		File source = scr.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		File dest = new File("C:\\Users\\lppaw\\Desktop\\BDD2026\\BDD2016Project\\Screenshot/" + scenario.getName() + ""
				+ date.getDate() + date.getTime() + ".png");
		FileHandler.copy(source, dest);
		

	}
	
	public void scrolltoWebElement(WebElement element,WebDriver driver) {
	//WebElement element = driver.findElement(By.id("my-element-id"));

	JavascriptExecutor js = (JavascriptExecutor) driver;
	// Scrolls the page until the element is in view
	js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
	
	
	
	public void WaitForElementtobeClicable(WebElement element,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

}
