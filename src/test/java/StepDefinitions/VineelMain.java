package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import BrowserSetup.BrowserDriver;
import Elements.VineelElements;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ExcelReader;
import utilities.excelWrite;

public class VineelMain {
	VineelElements input;
	@Given("^Open browser and Navigate URL$")
	public void open_browser_and_navigate_url() {
	    System.out.println("Browser Launch");
	}

	@When("^Click on yes$")
	public void click_on_yes() throws InterruptedException {
		 System.out.println("Clicked on yes");
		 input=PageFactory.initElements(BrowserDriver.getCurrentDriver(), VineelElements.class);
		 Thread.sleep(1000);
		 input.Alerts();
		 Thread.sleep(1000);
		 input.ClickOnYes();
	}

	@When("^Enter amount$")
	public void enter_amount() throws InterruptedException {
		 System.out.println("Entered Amount");
		 Thread.sleep(1000);
		 input.Amountenter();
	}

	@When("^Enter years$")
	public void enter_years() throws InterruptedException {
		 System.out.println("Entered no.of years");
		 Thread.sleep(1000);
		 input.Yearsenter();
	}

	@And("^Click on submit$")
	public void click_on_submit() throws InterruptedException {
		 System.out.println("Checking Amount");
		 Thread.sleep(1000);
		 input.Subbtn();
		 Thread.sleep(1000);
		 input.validate();
		 input.excelwrite();
		 
	}

	@Then("^Generate report and Close browser$")
	public void generate_report_and_close_browser() throws InterruptedException, IOException {
		 System.out.println("Browser Closed");
		 Thread.sleep(1000);
		 input.Close();
	}
}
