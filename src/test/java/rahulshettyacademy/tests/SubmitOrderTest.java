package rahulshettyacademy.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.OrderHistoryPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.testcomponents.BaseTests;

public class SubmitOrderTest extends BaseTests {
	
	String productName = "ZARA COAT 3";
	
    @Test
    public void submitOrder() throws IOException {     
        ProductCatalogue productCatalogue = landingPage.loginApplication("dks@rediff.com", "John@12345");
        // List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage = productCatalogue.goToCartPage();
        boolean productFound = cartPage.verifyProductInCart(productName);
        Assert.assertTrue(productFound, "Product not found in the cart as expected");
        CheckoutPage checkoutPage = cartPage.checkOut();
        checkoutPage.selectCountryFromDropDown("India");
        ConfirmationPage confirmationPage = checkoutPage.clickOnPlaceOrder();

        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
    }
    
    //To verify ZARA COAT 3 is displaying in the order section
    //DependsOnMethod is used to confirm that atleast one ZARA COAT 3 item is present in the orders.
    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistory() {
    	 ProductCatalogue productCatalogue = landingPage.loginApplication("dks@rediff.com", "John@12345");
    	OrderHistoryPage orderHistoryPage = productCatalogue.goToOrderPage();
    	boolean productSelected = orderHistoryPage.verifyOrderDisplay(productName);
    	Assert.assertTrue(productSelected,"Product not found in the Orders List");
    }

}