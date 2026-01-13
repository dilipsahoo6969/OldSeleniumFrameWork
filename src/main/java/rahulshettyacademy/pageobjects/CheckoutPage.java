package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver2) {
		super(driver2);
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[placeholder = 'Select Country']")
	private WebElement countryDetails;
	
	@FindBy(xpath = ("(//button[contains(@class,'ta-item')])[2]"))
	private WebElement selectCountry;
	
//	@FindBy(css = ".action__submit")
//	private WebElement submit;
	
	//This variable is taken to pass to the waitForElementToAppear() method for activating the wait.
	By countryToBeVisible = By.cssSelector(".ta-results");
	By submitButton = By.cssSelector(".action__submit");
	
	public void selectCountryFromDropDown(String country) {
		Actions a = new Actions(driver);
        a.sendKeys(countryDetails, country).build().perform();
        waitForElementToBeVisible(countryToBeVisible);
        selectCountry.click();
	}
	
//	public ConfirmationPage clickOnPlaceOrder() {
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 32000);");
//		WebElement button = waitForElementToBeClickable(submitButton);
//		button.click();
//		return new ConfirmationPage(driver);
//	}
	
	public ConfirmationPage clickOnPlaceOrder() {
		WebElement button = driver.findElement(By.cssSelector(".action__submit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		return new ConfirmationPage(driver);
	}
	
}
