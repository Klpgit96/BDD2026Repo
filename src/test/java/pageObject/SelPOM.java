package pageObject;

import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basepackage.BaseClass;

public class SelPOM {
	public WebDriver driver;
	public BaseClass base;
	public String parent;
	String expectedTitle1 = "XPath Practice - H Y R Tutorials";
	public Date dte;

	public SelPOM(WebDriver driver2) {
		driver = driver2;
		base = new BaseClass(driver);
		dte = new Date();
		PageFactory.initElements(driver2, this);
	}

	@FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
	public WebElement alertframewindwcard;

	@FindBy(xpath = "//span[text()=\"Alerts\"]")
	public WebElement alert1;

	@FindBy(xpath = "//h5[text()=\"Book Store Application\"]")
	public WebElement ele;

	@FindBy(id = "alertButton")
	public WebElement smlalert;

	@FindBy(id = "timerAlertButton")
	public WebElement timerAlertButton;

	@FindBy(id = "promtButton")
	public WebElement promtButton;

	@FindBy(id = "promptResult")
	public WebElement promptResult;

	/////////////

	@FindBy(xpath = "//button[starts-with(@id,\"newTabsW\")]")
	public WebElement newTabsWindowsBtn;

	@FindBy(id = "name")
	public WebElement input;

	/////////////////

	@FindBy(id = "name")
	public WebElement name;

	@FindBy(id = "selectnav1")
	public WebElement selectnav1;

	@FindBy(id = "frm1")
	public WebElement child1;

	@FindBy(id = "frm2")
	public WebElement child2;

	@FindBy(id = "frm3")
	public WebElement frame3;

	@FindBy(id = "name")
	public WebElement frame3Input;

	@FindBy(xpath = "//h2[text()='Support My Work']")
	public WebElement child1Content;

	@FindBy(xpath = "//a[contains(text(),'Click here to navigate to the home')]")
	public WebElement childC2ontent;

	// date handling

	

	@FindBy(xpath = "//table[@class=\"ui-datepicker-calendar\"]//tbody//tr//td")
	public List<WebElement> actualDate;

	public int Expectedcurrentdate = 17;
	public String ExpectedMonth = "October";
	public String ExpectedYear = "2026";

	@FindBy(xpath = "//a[@class=\"ui-datepicker-next ui-corner-all\"]")
	public WebElement Forward;

	@FindBy(xpath = "//a[@class=\"ui-datepicker-prev ui-corner-all\"]")
	public WebElement Backward;

	@FindBy(xpath = "//input[@id=\"first_date_picker\"]")
	public WebElement firstDate;
	@FindBy(xpath = "//span[@class=\"ui-datepicker-month\"]")
	public WebElement actualMonth;

	@FindBy(xpath = "//span[@class=\"ui-datepicker-year\"]")
	public WebElement actualYear;
	
	@SuppressWarnings("rawtypes")
	public void selectCurrentDate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(firstDate));
		firstDate.click();
		while (true) {
		String catMonth=	actualMonth.getText();
			String actYear=actualYear.getText();
			if (catMonth.equals(ExpectedMonth) && actYear.equals(ExpectedYear)) {
				// boolean dateFound = false;)
				
				
				for (WebElement e :actualDate) {
					String day=	e.getText();
					if (day.equals(Expectedcurrentdate)) {
					e.click();;
					
						break;

					}
				}
				break;
				
			} 
			else {
				Forward.click();
			}

		}
		System.out.println("firs selectede current Date : " + firstDate.getAttribute("value"));

	}

	public void validateFirstiframe() throws InterruptedException {
		name.sendKeys("iframe handling");
		System.out.println("Entered text : " + name.getAttribute("value"));
		// driver.switchTo().frame("frm1");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frm1"));
		Select select = new Select(selectnav1);
		select.selectByIndex(1);
		Thread.sleep(300);
		select.selectByValue("https://www.hyrtutorials.com/search/label/Tutorials");
		Thread.sleep(300);
		select.selectByVisibleText("- SQL");

		driver.switchTo().parentFrame();
		name.clear();
		name.sendKeys("Nested iframe handling");
		System.out.println("Entered text : " + name.getAttribute("value"));

	}

	public void validateNestedIfrane() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame3));
		frame3Input.sendKeys("switch to child frame 1");
		System.out.println("Entered text : " + frame3Input.getAttribute("value"));

		// child1
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(child1));
		String ttl = child1Content.getText();
		System.out.println(ttl);
		driver.switchTo().parentFrame();
		frame3Input.clear();
		frame3Input.sendKeys("switch to child frame 2");

//child2
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(child2));
		String tt2 = childC2ontent.getText();
		System.out.println(tt2);
		driver.switchTo().parentFrame();
		frame3Input.clear();
		frame3Input.sendKeys("switched to parent frame");
		String tt11 = frame3Input.getText();
		System.out.println(tt11);

		// main page
		// wait.until(ExpectedConditions.f)
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(name));
		name.clear();
		name.sendKeys("nested frame handling completed !");
		String tt = name.getText();
		System.out.println(tt);

	}

	@FindBy(xpath = "//i[@class=\"top-header-date-icon fa fa-calendar-o\"]")
	public WebElement date;

	public void clickonnewTabsWindowsBtn() {
		input.sendKeys("multiple wndow handling");
		parent = driver.getWindowHandle();
		System.out.println("Parent window  id: " + parent);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(newTabsWindowsBtn));
		newTabsWindowsBtn.click();

	}

	public void handlemultipleWindow() {
		Set<String> child = driver.getWindowHandles();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		System.out.println(child.size());

		List list = new LinkedList();
		list.addAll(child);

		Iterator itr = child.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());

		}

		for (int i = 0; i <= list.size() - 1; i++) {
			driver.switchTo().window((String) list.get(i));
			System.out.println(" window url : " + driver.getCurrentUrl());
			System.out.println(" window title : " + driver.getTitle());
			if (expectedTitle1.equals(driver.getTitle())) {
				String text = date.getText();
				System.out.println(text);
				System.out.println("current window title : " + driver.getTitle());
				// driver.close();
			}
		}

	}

	public void clickonpromptbutton() {
		alert1.click();
		promtButton.click();
	}

	public void HandlepromtAlertWithAccept() {
		// alert1.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String prompt = alert.getText();
		System.out.println("Prompt alert Title : " + prompt);
		alert.sendKeys("Lalasaheb");
		alert.accept();
		String result = promptResult.getText();
		System.out.println("Prompt alert result : " + result);

	}

	public void HandlepromtAlertWithDismiss() {
		promtButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String prompt = alert.getText();
		System.out.println("Prompt alert Title : " + prompt);
		alert.sendKeys("Lalasaheb");
		alert.dismiss();
		// String result = promptResult.getText();
		// System.out.println("Prompt alert result : " + result);

	}

	public void handletimerAlertButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String timer = alert.getText();
		System.out.println("Timer alert Title : " + timer);
		alert.accept();

	}

	public void clickOntimerAlertButton() {
		base.scrolltoWebElement(timerAlertButton, driver);
		base.WaitForElementtobeClicable(timerAlertButton, driver);
		timerAlertButton.click();
	}

	public void clickon_alertframewindwcard() {

		base.scrolltoWebElement(ele, driver);
		base.WaitForElementtobeClicable(alertframewindwcard, driver);
		alertframewindwcard.click();
	}

	public void clickOnsimplealertButton() {
		alert1.click();
		base.scrolltoWebElement(smlalert, driver);
		base.WaitForElementtobeClicable(smlalert, driver);
		smlalert.click();
	}

	public void simplealertValidate() {
		// Alert alert =driver.switchTo().alert();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertLabel = alert.getText();
		System.out.println("Simple alert title : " + alertLabel);

	}

	public void alertAccept() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}

}
