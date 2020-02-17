package stepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Assert;


public class StepDefinition {

	WebDriver driver;

	// Following are the definitions for the Background
	@Given("^User has navigated to Trivago website$")
	public void user_has_navigated_to_Trivago_website(){
		System.setProperty("webdriver.chrome.driver", "browser_drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://trivago.com/");
		driver.manage().window().maximize();
		
		//Choose the country as US since the website redirects based on location
		Select subDropDown = new Select(
				driver.findElement(By.id("select-country")));
		subDropDown.selectByValue("us");
		
		//To check the title of the homepage
		String firstPageTitle = driver.getTitle();
		Assert.assertEquals("trivago.com - Compare hotel prices worldwide", firstPageTitle);
		System.out.println("The title of the Homepage of Trivago is verified" + firstPageTitle);
	}

	
	@When("^User provides input of place and type$")
	public void user_provides_input_of_place_and_type(){
		// user provides the city name
				WebElement cityTextBox = driver
						.findElement(By.name("sQuery"));
				//cityTextBox.click();
				//cityTextBox.clear();
				cityTextBox.sendKeys("Hilden");
				cityTextBox.sendKeys(Keys.TAB);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cityTextBox.sendKeys(Keys.TAB);
				
				
	}

	@And("^Clicks on the search button$")
	public void clicks_on_the_search_button(){
		WebElement searchButton = driver
				.findElement(By.xpath("//*[@id='js-fullscreen-hero']/div[1]/div[2]/button[2]"));
		searchButton.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	@Then("^User is redirected to the search results page$")
	public void user_is_redirected_to_the_search_results_page(){
		String resultsPageTitle = driver.getTitle();
		Assert.assertEquals("Hilden Hotels | Find & compare great deals on trivago", resultsPageTitle);
	    System.out.println("The title of the Search page results is verified" + resultsPageTitle );
	}

	
	
	//This is the end of the background steps and start of Scenarios
	
	@Given("^User is on the search results page$")
	public void user_is_on_the_search_results_page(){
		String resultsPageTitle = driver.getTitle();
		Assert.assertEquals("Hilden Hotels | Find & compare great deals on trivago", resultsPageTitle);
	    
	}

	


	@When("^chooses for custom applied filters$")
	public void chooses_for_custom_applied_filters(){
		WebElement customFiltersButton = driver
				.findElement(By.xpath("//*[@id='page_wrapper']/section/div/div/ul/li[5]/button"));
		customFiltersButton.click();
		WebElement wifiFilter = driver
				.findElement(By.id("254/300-0"));
		wifiFilter.click();
		System.out.println("The user chooses filter of: Wifi" );
	}

	@And("^clicks on Done button$")
	public void clicks_on_Done_button() {
		WebElement doneFilterButton = driver
				.findElement(By.id("filter-popover-done-button"));
		doneFilterButton.click();
	}

	@And("^user sorts the results by price only$")
	public void user_sorts_the_results_by_price_only() {
		Select priceOnly = new Select(driver.findElement(By.name("mf-select-sortby")));
		priceOnly.selectByVisibleText("Price only");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The user chooses a sort option of: Price only" );
	}
	@Then("^User sees the relevant recommendations$")
	public void user_sees_the_relevant_recommendations(){
		
	//To check the serach results included the selected filter
		String wifiCheck = driver
				.findElement(By.xpath("/html/body/div[3]/main/div[1]/div/div[4]/div/div/div[3]/div[1]/section/ol/li[1]/article/div[1]/div[2]/div/div[3]/dl/dd")).getText();
		//System.out.println(wifiCheck);
		Assert.assertEquals("WiFi", wifiCheck);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("The filter chosen by user is applied succssfully" );
		
		
		String accoPartnerName = driver
				.findElement(By.xpath("//*[@id='9852']/article/div[1]/div[2]/section/div[2]/article/div/div/p/span")).getText();
		//System.out.println(accoPartnerName);
		
		String leastPrice = driver
				.findElement(By.xpath("//*[@id='9852']/article/div[1]/div[2]/section/div[2]/article/div/div/p/strong")).getText();
		String leastPricewithoutdollar = leastPrice.replace("$","");
		int valueOfleast=Integer.parseInt(leastPricewithoutdollar);
		//System.out.println(valueOfleast);
		
		String nxtBestPrice = driver
				.findElement(By.xpath("//*[@id='703006']/article/div[1]/div[2]/section/div[2]/article/div/div/p/strong")).getText();
		
		String nxtBestPricewithoutdollar = nxtBestPrice.replace("$","");
		int valueOfsecondleast=Integer.parseInt(nxtBestPricewithoutdollar);
		//System.out.println(valueOfsecondleast);
		
		if(valueOfleast < valueOfsecondleast)
		{
			System.out.println("The hotels are sorted by price only");
		} else{
			System.out.println("The hotels are NOT sorted by price only");
		}
		
			WebElement viewDealBtn = driver
					.findElement(By.xpath("//*[@id='9852']/article/div[1]/div[2]/section/div[2]/article/div/div/button"));
			viewDealBtn.click();
		
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    String hotelPageTitle = driver.getTitle();
		
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
		
		if(hotelPageTitle.contains(accoPartnerName)){
			System.out.println("Trivago redirects the page to correct accoomodation partner");
			
		}else{
			System.out.println("Wrong redirection to hotel");
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.close();
		driver.quit();
	}
	
	
}

