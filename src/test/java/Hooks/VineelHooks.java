package Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BrowserSetup.BrowserDriver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class VineelHooks {
@Before
public void startBrowser() {
	BrowserDriver.getCurrentDriver().get("https://www.moneycontrol.com/personal-finance/tools/gratuity-calculator.html");
}
@AfterStep
public void addScreenshot(Scenario scenario){

	//validate if scenario has failed
	if(scenario.isFailed()) {
		final byte[] screenshot = ((TakesScreenshot) BrowserDriver.getCurrentDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "image"); 
	}
}
}
