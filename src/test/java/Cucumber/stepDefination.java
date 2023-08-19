package Cucumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Config.BrowserConfig;
import PageFactory.GreenKart.LandingPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class stepDefination extends BrowserConfig {
	public LandingPage landingPage;
	private List<Map<String, String>> credentialsList = new ArrayList<Map<String, String>>();
	private List<String> itemsToSelect = new ArrayList<String>();
	private List<String> productsToSelect;
	
	@Given("Navigate To GreenKart Applications") 
	public void Navigate_To_GreenKart_Applications() {
		landingPage = LandingApplication();		
	}
	
	
    @When("Add Items Into Cart and Click On Cart Icon")
    public void Add_Items_Into_Cart_and_Click_On_Cart_Icon(DataTable dataTable) {
//        itemsToSelect = dataTable.asList(String.class);
    	productsToSelect = dataTable.asList(String.class);
    	for(int i=0;i<productsToSelect.size();i++) {
    		System.out.println(productsToSelect.get(i));
    	}
        landingPage.addItemsIntoCart((ArrayList<String>) productsToSelect);
		landingPage.ClickOnCartIcon();
    }

}
