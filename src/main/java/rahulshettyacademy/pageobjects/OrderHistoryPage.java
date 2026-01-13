package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponent.AbstractComponent;

public class OrderHistoryPage extends AbstractComponent{
	
	public WebDriver driver;
	
	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> productNames;
	
	public boolean verifyOrderDisplay(String selectedProduct) {
		boolean productFound = false;
		for(WebElement prod: productNames) {
			if(prod.getText().equalsIgnoreCase(selectedProduct)) {
				productFound = true;
				break;
			}
		}
		return productFound;
	}
	

}
