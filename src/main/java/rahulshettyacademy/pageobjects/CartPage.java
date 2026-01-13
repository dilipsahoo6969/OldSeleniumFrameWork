package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver; 
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;
	
	@FindBy(css = ".totalRow button")
	private WebElement checkOutButton;
	
	public boolean verifyProductInCart(String productToBeSelected) {
		boolean productFound = false;
		
		for (WebElement cartProduct: cartProducts) {
            String productInTheCart = cartProduct.getText();
            if (productInTheCart.equalsIgnoreCase(productToBeSelected)) {
                productFound = true;
                break;
            }
        }
		return productFound;
	}
	
	public CheckoutPage checkOut() {
		checkOutButton.click();
		return new CheckoutPage(driver);
		
	}

}
