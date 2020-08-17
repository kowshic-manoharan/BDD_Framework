/**
 *  this code is used to check all the components in the page is working
 */
package stepDefenitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectRepository.ComponentPageObjects;

public class ComponentsPage {

	public static WebDriver driver;

	ComponentPageObjects cpo = new ComponentPageObjects(driver);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	ArrayList<String> expectedCourses = new ArrayList<String>();

	List<String> actualCourses = new ArrayList<String>();

	@Given("^user is on the Components page$")
	public void user_is_on_the_components_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium Drivers\\chrome driver 83\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}

	@When("^user navigate to the page$")
	public void user_navigate_to_the_page() throws Throwable {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}

	@Then("^Component page should display$")
	public void component_page_should_display() throws Throwable {
		Assert.assertEquals(driver.getTitle(), "Practice Page");
	}

	@When("^clicking on the second radio button$")
	public void clicking_on_the_second_radio_button() throws Throwable {
		cpo.clickRadioButton();
	}

	@Then("^second radio button have to select$")
	public void second_radio_button_have_to_select() throws Throwable {
		Assert.assertEquals(cpo.clickRadioButton().isSelected(), true);
	}

	@When("^entering the letters in the field$")
	public void entering_the_letters_in_the_field() throws Throwable {
		cpo.getAutoSuggest().sendKeys("Ind");
	}

	@Then("^Corresponding letter country display$")
	public void corresponding_letter_country_display() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.xpath("//li[2]//div[1]"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		
		String script = "return document.getElementById(\"autocomplete\").value;";
		String text = (String) js.executeScript(script);
		Assert.assertEquals(text, "India");
	}

	@When("^select the value in the drop down$")
	public void select_the_value_in_the_drop_down() throws Throwable {
		Select dropDown = new Select(cpo.selectDropDownValue());
		dropDown.selectByIndex(1);
	}

	@Then("^Corresponding value have to be displayed$")
	public void corresponding_value_have_to_be_displayed() throws Throwable {
		Select dropDown = new Select(cpo.selectDropDownValue());
		String value1 = dropDown.getFirstSelectedOption().getText();
		Assert.assertEquals(value1, "Option1");
	}

	@When("^check the second checkbox$")
	public void check_the_second_checkbox() throws Throwable {
		cpo.checkCheckBox().click();
	}

	@Then("^Corresponding check box have to be selected$")
	public void corresponding_check_box_have_to_be_selected() throws Throwable {
		Assert.assertEquals(cpo.checkCheckBox().isSelected(), true);
	}

	@When("^click on the Open window button$")
	public void click_on_the_open_window_button() throws Throwable {
		cpo.getNewWindow().click();
	}

	@Then("^new window have to opened$")
	public void new_window_have_to_opened() throws Throwable {
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(),
				"QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");
		driver.close();
		driver.switchTo().window(parentId);
	}

	@When("^click on the Open tab button$")
	public void click_on_the_open_tab_button() throws Throwable {
		cpo.getNewTab().click();
	}

	@Then("^new tab have to opened$")
	public void new_tab_have_to_opened() throws Throwable {
		Set<String> id = driver.getWindowHandles();
		Iterator<String> it = id.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(), "Rahul Shetty Academy");
		driver.close();
		driver.switchTo().window(parentId);
	}

	@When("^entering the value and click the button$")
	public void entering_the_value_and_click_the_button() throws Throwable {
		cpo.setTextBox().sendKeys("Kowshic");
		Thread.sleep(1000);
		cpo.clickAlertButton().click();
	}

	@Then("^alert have to display$")
	public void alert_have_to_display() throws Throwable {
		driver.switchTo().alert().accept();
	}

	@When("^checking course list$")
	public void checking_course_list() throws Throwable {
		WebElement tablevalue = cpo.producttable();

		expectedCourses.add("Selenium Webdriver with Java Basics + Advanced + Interview Guide");
		expectedCourses.add("Learn SQL in Practical + Database Testing from Scratch");
		expectedCourses.add("Appium (Selenium) - Mobile Automation Testing from Scratch");
		expectedCourses.add("WebSecurity Testing for Beginners-QA knowledge to next level");
		expectedCourses.add("Learn JMETER from Scratch - (Performance + Load) Testing Tool");
		expectedCourses.add("WebServices / REST API Testing with SoapUI");
		expectedCourses.add("QA Expert Course :Software Testing + Bugzilla + SQL + Agile");
		expectedCourses.add("Master Selenium Automation in simple Python Language");
		expectedCourses.add("Advanced Selenium Framework Pageobject, TestNG, Maven, Jenkins,C");
		expectedCourses.add("Write effective QA Resume that will turn to interview call");

		int courses = tablevalue.findElements(By.cssSelector("tbody td:nth-child(2)")).size();
		for (int i = 0; i < courses; i++) {
			actualCourses.add(i, tablevalue.findElements(By.cssSelector("tbody td:nth-child(2)")).get(i).getText());
		}
		System.out.println("Actual course list in screen :" + actualCourses);
	}

	@Then("^course list is displayed as per requirement$")
	public void course_list_is_displayed_as_per_requirement() throws Throwable {
		System.out.println("Expected course list in screen :" + expectedCourses);
		Assert.assertEquals(actualCourses, expectedCourses);
	}
	
	@When("^i am clicking on the Hide button$")
	public void i_am_clicking_on_the_Hide_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 cpo.clickHideButton().click();
	}

	@When("^i am clicking on the show button$")
	public void i_am_clicking_on_the_show_button() throws Throwable {
		 cpo.clickShowButton().click();
	}

    @Then("^Hide Show text box should hide$")
    public void hideshow_text_box_should_hide() throws Throwable {
    	Assert.assertEquals(cpo.getTextBoxProp().isDisplayed(), false);
    }

    @Then("^Hide Show text box should show$")
    public void hideshow_text_box_should_show() throws Throwable {
    	Assert.assertEquals(cpo.getTextBoxProp().isDisplayed(), true);
    }
    
    @When("^Hovering on the Mouse Hower button$")
    public void hovering_on_the_mouse_hower_button() throws Throwable {
    	js.executeScript("arguments[0].scrollIntoView();", cpo.getMouseHower());
    	Actions ac = new Actions(driver);
        ac.moveToElement(cpo.getMouseHower()).build().perform();
    }

    @Then("^Options have to display$")
    public void options_have_to_display() throws Throwable {
        cpo.getHowerElement().isDisplayed();
    }
    
    @When("^clicking on all the links to open in seperate tab$")
    public void clicking_on_all_the_links_to_open_in_seperate_tab() throws Throwable {
    	driver.switchTo().frame(cpo.getIframe());
    	WebElement link = cpo.getIframeNavigationLinks();
    	link.findElements(By.tagName("a")).size();
    	for (int i = 0; i < link.findElements(By.tagName("a")).size(); i++) {
			String clickOnTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			link.findElements(By.tagName("a")).get(i).sendKeys(clickOnTab);
		}	
    }

    @Then("^all the links are opened in individual tab$")
    public void all_the_links_are_opened_in_individual_tab() throws Throwable {
		Set<String> linkPage = driver.getWindowHandles();
		Iterator<String> it = linkPage.iterator();
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
		}
    }


	@After
	public void afterScenario(Scenario scenario) {
		String screenshotName;
		if (scenario.isFailed()) {
			screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				// This takes a screenshot from the driver at save it to the specified location
				File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// Building up the destination path for the screenshot to save
				// Also make sure to create a folder 'screenshots' with in the cucumber-report
				// folder
				File destinationPath = new File(System.getProperty("user.dir")
						+ "/target/cucumber-reports/screenshots/FailedScenario" + screenshotName + ".png");

				// Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);

				// This attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			}
		} else
			screenshotName = scenario.getName().replaceAll(" ", "_");
		try {
			// This takes a screenshot from the driver at save it to the specified location
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			// Building up the destination path for the screenshot to save
			// Also make sure to create a folder 'screenshots' with in the cucumber-report
			// folder
			File destinationPath = new File(System.getProperty("user.dir")
					+ "/target/cucumber-reports/screenshots/PassedScenario" + screenshotName + ".png");

			// Copy taken screenshot from source location to destination location
			Files.copy(sourcePath, destinationPath);

			// This attach the specified screenshot to the test
			Reporter.addScreenCaptureFromPath(destinationPath.toString());
		} catch (IOException e) {
		}

	}

}
