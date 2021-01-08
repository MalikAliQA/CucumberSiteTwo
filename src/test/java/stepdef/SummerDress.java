package stepdef;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SummerDress {
	
	private static WebDriver driver;
	private static String URL = "http://automationpractice.com/index.php";
	
	@Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("http://automationpractice.com/index.php");
    }
	
	@After
    public void tearDown() {
        driver.close();
	}
	
	
	@Given("^I can access the shopping site$")
	public void i_can_access_the_shopping_site() throws Throwable {
		driver.get(URL);
		//Thread.sleep(2000);//sleep implemented for visual purpose to slow process down

	}

	@When("^I search for a dress$")
	public void i_search_for_a_dress() throws Throwable {
        WebElement search = driver.findElement(By.cssSelector("#search_query_top"));
        String item = "dress";
    	search.sendKeys(item);
    	//Thread.sleep(2000);//sleep implemented for visual purpose to slow process down
        WebElement submit = driver.findElement(By.cssSelector("#searchbox > button"));
        submit.click();
      //Thread.sleep(2000);//sleep implemented for visual purpose to slow process down
	}

	@Then("^I can find and select the first summer dress$")
	public void i_can_find_and_select_the_first_summer_dress() throws Throwable {
		WebElement resultItem = driver.findElement(By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.left-block > div > a.product_img_link > img") );
        resultItem.click();
      //Thread.sleep(2000);//sleep implemented for visual purpose to slow process down
        WebElement itemName = driver.findElement(By.cssSelector("h1"));
        assertEquals("Printed Summer Dress", itemName.getText());
	}


}
