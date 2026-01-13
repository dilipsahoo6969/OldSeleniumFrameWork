package rahulshettyacademy.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.testcomponents.BaseTests;

public class ErrorValidationsTest extends BaseTests {

    @Test(groups = {"ErrorHandling"})
    public void LoginErrorValidation(){
    	landingPage.loginApplication("dkssd@rediff.com", "Johnad@12345");
    	Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());;
    }
    
    @Test
    public void ProductErrorValidations() throws IOException {
        String productToBeSelected = "ZARA COAT 3";
        ProductCatalogue productCatalogue = landingPage.loginApplication("dilipsahoo455@gmail.com", "Dilip@1234");
        productCatalogue.addProductToCart(productToBeSelected);
        CartPage cartPage = productCatalogue.goToCartPage();
        boolean productFound = cartPage.verifyProductInCart("ZARA COAT 324");
        Assert.assertFalse(productFound);      
    }
    
    //This is the command to see the changes in Git hub.
    //Again commiting for testing purpose.
    //Again third commit; fifth commit removed from rahul.
    //Hello there	again there
}