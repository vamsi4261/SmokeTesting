package PageFactory.GreenKart;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckOutPage {
	
	WebDriver driver;
	
	@FindBy (xpath = "//tbody/tr/td[2]/p")
	List<WebElement> CheckoutItems;
	
	@FindBy (xpath = "//button[contains(text(),'Place Order')]")
	WebElement OrderBtn;
	
	@FindBy (tagName = "Select")
	WebElement CountryDropDown;
	
	@FindBy (css = ".chkAgree")
	WebElement Terms_Conditions;
	
	@FindBy (xpath = "//button[contains(text(),'Proceed')]")
	WebElement ProceedBtn;

	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	
	

	public ArrayList<String> getCheckoutItems() {
		ArrayList<String> checkoutList = new ArrayList<String>();
		for(int i=0;i<CheckoutItems.size();i++) {
			checkoutList.add(CheckoutItems.get(i).getText().split("-")[0].trim());
			System.out.println(CheckoutItems.get(i).getText().split("-")[0].trim());
		}
		return checkoutList;
	}
	
	public void validateCheckoutItems(ArrayList<String> itemsNeeded) {
		Assert.assertTrue(getCheckoutItems().containsAll(itemsNeeded));
	}
	
	public void OrderBtn() {
		OrderBtn.click();
	}
	
	public void SelectCountryAndPlaceOrder(String Country) {
		Select s = new Select(CountryDropDown);
		s.selectByVisibleText(Country);
		Terms_Conditions.click();
		Assert.assertTrue(Terms_Conditions.isSelected());
		ProceedBtn.click();	
		
		
	}

	

}
