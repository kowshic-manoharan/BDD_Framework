/**
 * 
 */
package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author kowshic
 *
 */
public class ComponentPageObjects {

	WebDriver driver;

	public ComponentPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[1]//fieldset[1]//label[2]//input[1]")
	WebElement radioButton;
	
	@FindBy(xpath="//input[@placeholder='Type to Select Countries']")
	WebElement autoSuggest;
	
	@FindBy(xpath="//select[@name='dropdown-class-example']")
	WebElement dropDown;
	
	@FindBy(xpath="//input[@name='checkBoxOption2']")
	WebElement checkBox;
	
	@FindBy(xpath="//button[contains(text(),'Open Window')]")
	WebElement newWindow;
	
	@FindBy(xpath="//a[contains(text(),'Open Tab')]")
	WebElement newTab;
	
	@FindBy(xpath="//input[@placeholder='Enter Your Name']")
	WebElement textBox;
	
	@FindBy(xpath="//div[3]//fieldset[1]//input[2]")
	WebElement alert;
	
	@FindBy(xpath="//table[@id='product']")
	WebElement table;
	
	@FindBy(xpath="//input[@id='hide-textbox']")
	WebElement hideButton;
	
	@FindBy(xpath="//input[@id='show-textbox']")
	WebElement showButton;
	
	@FindBy(xpath="//input[@id='displayed-text']")
	WebElement textBoxprop;
	
	@FindBy(xpath="//button[@id='mousehover']")
	WebElement mouseHower;
	
	@FindBy(xpath="//div[@class='mouse-hover-content']")
	WebElement howerElement;
	
	@FindBy(xpath="//iframe[@id='courses-iframe']")
	WebElement iframe;
	
	@FindBy(xpath="/html/body/app-root/div/header/div[2]/div/div/div[2]/nav/div[2]/ul/li[4]/a")
	WebElement practiceProject;
	
    @FindBy(xpath="/html/body/app-root/div/header/div[2]/div/div/div[2]/nav/div[2]")
    WebElement iframeNavigationLinks;

	public WebElement clickRadioButton() {
		radioButton.click();
		return radioButton;
	}
	
	public WebElement getAutoSuggest() {
		return autoSuggest;
	}
	
	public WebElement selectDropDownValue() {
		dropDown.click();
		return dropDown;
	}
	
	public WebElement checkCheckBox() {
		return checkBox;
	}
	
	public WebElement getNewWindow() {
		return newWindow;
	}
	
	public WebElement getNewTab() {
		return newTab;
	}
	
	public WebElement setTextBox() {
		return textBox;
	}
	
	public WebElement clickAlertButton() {
		return alert;
	}
	
	public WebElement producttable() {
		return table;
	}
	
	public WebElement clickHideButton() {
		return hideButton;
	}
	
	public WebElement clickShowButton() {
		return showButton;
	}
	
	public WebElement getTextBoxProp() {
		return textBoxprop;
	}
	
	public WebElement getMouseHower() {
		return mouseHower;
	}
	
	public WebElement getHowerElement() {
		return howerElement;
	}
	
	public WebElement getIframe() {
		return iframe;
	}
	
	public WebElement getPracticeProjectLink() {
		return practiceProject;
	}
	
	public WebElement getIframeNavigationLinks() {
		return iframeNavigationLinks;
	}

}
