package PageFactory.GreenKart;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	@FindBy (tagName = "h4")
	List<WebElement> GreenKartProducts;
	
	@FindBy (xpath = "//button[contains(text(),'ADD TO CART')]")
	List<WebElement> AddToCartButton;
	
	@FindBy (css = ".cart-icon")
	WebElement CartIcon;
	
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public ArrayList<String> getAllProducts() {
		ArrayList<String> ListOfProducts = new ArrayList<String>();
		for(int i=0;i<GreenKartProducts.size();i++) {
			ListOfProducts.add(GreenKartProducts.get(i).getText().split("-")[0].trim());
//			System.out.println(GreenKartProducts.get(i).getText().split("-")[0]);
		}
		return ListOfProducts;
	}
	
	public void addItemsIntoCart(ArrayList<String> itemsNeeded) {
		for(int i=0;i<getAllProducts().size();i++) {
			if(itemsNeeded.contains(getAllProducts().get(i))) {
//				System.out.println(i);
				AddToCartButton.get(i).click();
			}
		}
//		CartIcon.click();
	}
	
	public CartPage ClickOnCartIcon() {
		CartPage cartPage = new CartPage(driver);
		cartPage.CartIcon.click();
		return cartPage;
	}
	
	public void GoTo() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	

}
