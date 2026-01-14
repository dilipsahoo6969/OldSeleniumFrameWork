package rahulshettyacademy.tests;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.testcomponents.BaseTests;

public class StandAloneTestAfterPOM extends BaseTests{

    public static void main(String[] args) {

        String productToBeSelected = "ZARA COAT 3";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        ProductCatalogue productCatalogue = landingPage.loginApplication("dks@rediff.com", "John@12345");
        //List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productToBeSelected);
        CartPage cartPage = productCatalogue.goToCartPage();
        boolean productFound = cartPage.verifyProductInCart(productToBeSelected);
        Assert.assertTrue(productFound, "Product not found in the cart as expected");
        CheckoutPage checkoutPage = cartPage.checkOut();
        checkoutPage.selectCountryFromDropDown("India");
        ConfirmationPage confirmationPage = checkoutPage.clickOnPlaceOrder();

        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
         driver.quit();
    }

    //This command has been added in develop branch of Rahul. for leaning branches in git hub.
    
    //Now architect in dilip framework added his comment
}