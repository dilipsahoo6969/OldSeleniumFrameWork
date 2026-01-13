package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.abstractcomponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	//Initialization
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
		
	@FindBy(css = ".mb-3")
	private List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	private WebElement spinner;
	
	//This variable is taken to pass to the waitForElementToAppear() method for activating the wait.
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProductList(){
		waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		for (WebElement product: getProductList()) {
            String nameOfTheProduct = product.findElement(By.cssSelector("b")).getText();
            if (nameOfTheProduct.equalsIgnoreCase(productName)) {
                return product;
            }
        }
		return null;
	}

	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
	}
	
}
