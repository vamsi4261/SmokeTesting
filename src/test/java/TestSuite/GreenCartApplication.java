package TestSuite;

import java.util.ArrayList;

import org.testng.annotations.Test;

import Config.BrowserConfig;
import PageFactory.GreenKart.CartPage;
import PageFactory.GreenKart.CheckOutPage;

public class GreenCartApplication extends BrowserConfig{
	@Test
	public void LandingGreenCartApplication() {
		ArrayList<String> ItemsNeeded = new ArrayList<String>();
		ItemsNeeded.add("Tomato");
		ItemsNeeded.add("Potato");
		ItemsNeeded.add("Mango");
		ItemsNeeded.add("Strawberry");
		landingPage.getAllProducts();
		landingPage.addItemsIntoCart(ItemsNeeded);
		CartPage cartPage = landingPage.ClickOnCartIcon();
		cartPage.getCartItems();
		cartPage.validateCartItems(ItemsNeeded);
		cartPage.CheckoutBtnClick();
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		checkOutPage.validateCheckoutItems(ItemsNeeded);
		checkOutPage.OrderBtn();
		checkOutPage.SelectCountryAndPlaceOrder("India");
		
	}

}
