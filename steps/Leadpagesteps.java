package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Leadpagesteps {
	ChromeDriver driver;
	String leadID;

	@Given("Open the chrome browser")
	public void open_the_chrome_browser() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Given("Load the application url")
	public void loadApplicationUrl() {
		driver.get("http://leaftaps.com/opentaps/control/main");

	}

	@Given("Enter the username as {string}")
	public void enterUsername(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@Given("Enter the password as {string}")
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("Homepage should be displayed")
	public void verifyHomePage() {
		boolean displayed = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		if (displayed) {
			System.out.println("Home page is displayed");
		} else
			System.out.println("Home page is not displayed");
		
	}

	@When("Click on CRMSFA and Leads")
	public void clickOn_CRMSFAandLeads() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Leads")).click();

	}

	@When("Click on Create Lead")
	public void clickOnCreateLead() {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Cucumber");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Leadpage");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("J");
	}

	@Then("Enter required details and click Submit")
	public void leadSubmit() {

		driver.findElement(By.name("submitButton")).click();
		driver.close();
	}

	@When("Click on Find Lead")
	public void findLead() throws InterruptedException {
		driver.findElement(By.linkText("Find Leads")).click();

	}

	@Then("Enter Phone number and click Find Leads")
	public void searchAndfindLeads() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("Select Lead and click Delete")
	public void select_lead_and_click_delete() {
		driver.findElement(By.linkText("Delete")).click();
	}
	@Then("Delete Perform action")
	public void delete_perform_action() {
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String text = driver.findElement(By.className("x-paging-info")).getText();
		if (text.equals("No records to display")) {
			System.out.println("Text matched");
		} else {
			System.out.println("Text not matched");
		}
		driver.close();
	}
	
	@When("Select Lead and click Duplicate Lead")
	public void select_lead_and_click_duplicate_lead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
	}
	@Then("Duplicate Lead Perform action")
	public void duplicate_lead_perform_action() {
		driver.findElement(By.name("submitButton")).click();
		driver.close();
	}
	
	@When("Select Lead and click Edit")
	public void select_lead_and_click_edit() {
		driver.findElement(By.linkText("Edit")).click();
	}
	@Then("Edit Perform action")
	public void edit_perform_action() {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Cucumber");
		driver.findElement(By.name("submitButton")).click();
		driver.close();
	}

	/*
	 * @When("Select Lead and click {string}") public void
	 * selectLeadandClickeditDeleteDuplicate(String action) {
	 * driver.findElement(By.linkText(action)).click();
	 * 
	 * }
	 * 
	 * @Then("{string} perform action") public void
	 * editDeleteduplicateLeadperformAction(String method) {
	 * driver.findElement(By.linkText(method)).click(); if (method ==
	 * "Duplicate Lead") { //driver.findElement(By.linkText(method)).click();
	 * driver.findElement(By.name("submitButton")).click(); driver.close();} else if
	 * (method == "Delete") { //driver.findElement(By.linkText(method)).click();
	 * driver.findElement(By.linkText("Find Leads")).click();
	 * driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	 * driver.findElement(By.xpath("//button[text()='Find Leads']")).click(); String
	 * text = driver.findElement(By.className("x-paging-info")).getText(); if
	 * (text.equals("No records to display")) { System.out.println("Text matched");
	 * } else { System.out.println("Text not matched"); } driver.close(); } else if
	 * (method == "Edit") { //driver.findElement(By.linkText(method)).click();
	 * 
	 * driver.findElement(By.id("updateLeadForm_companyName")).clear();
	 * driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Cucumber");
	 * driver.findElement(By.name("submitButton")).click(); driver.close(); } }
	 */
	/*
	 * @Then("Select Lead and click Delete") public void selectLeadandDelete() {
	 * driver.findElement(By.linkText("Delete")).click(); }
	 */
	/*
	 * @When("Find Leads") public void findLeadsafterDelete(){
	 * driver.findElement(By.linkText("Find Leads")).click();
	 * driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	 * driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	 * 
	 * }
	 * 
	 * @Then("Error message should be displayed") public void
	 * errorMessageafterDelete() { String text =
	 * driver.findElement(By.className("x-paging-info")).getText(); if
	 * (text.equals("No records to display")) { System.out.println("Text matched");
	 * } else { System.out.println("Text not matched"); } driver.close(); }
	 */
	
	/* @Then("Select Lead and click Edit") */
	/*public void selectLeadandEdit() {
		
		driver.findElement(By.linkText("Edit")).click();
	}
	@Then("Edit details and submit")
	public void editDetailsandSubmit() {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Cucumber");
		driver.findElement(By.name("submitButton")).click();
		driver.close();
	}*/
}
