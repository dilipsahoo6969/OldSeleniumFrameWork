package rahulshettyacademy.abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderHistoryPage;

public class AbstractComponent {
	WebDriver driver;
	WebDriverWait wait;
	
	//Constructor
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderHistoryPage goToOrderPage() {
		orderHeader.click();
		return new OrderHistoryPage(driver);
	}
	
	
	public void waitForElementToAppear(By findBy) {
		
	    wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void waitForElementToBeVisible(By countryToBeVisible) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(countryToBeVisible));
	}
	
//	public WebElement waitForElementToBeClickable(By submitButton) {
//		return wait.until(ExpectedConditions.elementToBeClickable(submitButton));
//	}
	
	public WebElement waitForElementToBeClickable(By submitButton) {
		return wait.until(ExpectedConditions.elementToBeClickable(submitButton));
	}
	
}
