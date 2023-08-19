package PageFactory.GreenKart;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
	
	WebDriver driver;
	
	@FindBy (xpath = "//div[@class='cart-preview active']/div/div/ul/li/div/p[@class='product-name']")
	List<WebElement> CartItems;
	
	@FindBy (xpath = "//button[contains(text(),'ADD TO CART')]")
	List<WebElement> AddToCartButton;
	
	@FindBy (css = ".cart-icon")
	WebElement CartIcon;
	
	@FindBy (xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")
	WebElement CheckoutBtn;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public ArrayList<String> getCartItems() {
		ArrayList<String> cartList = new ArrayList<String>();
		for(int i=0;i<CartItems.size();i++) {
			cartList.add(CartItems.get(i).getText().split("-")[0].trim());
		}
		return cartList;
	}
	
	public void validateCartItems(ArrayList<String> itemsNeeded) {
		Assert.assertTrue(getCartItems().containsAll(itemsNeeded));
	}
	

	
	public void CheckoutBtnClick() {
		CheckoutBtn.click();
	}

}
