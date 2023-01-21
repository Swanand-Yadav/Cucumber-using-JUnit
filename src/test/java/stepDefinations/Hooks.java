package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks 
{
	TestContextSetup tcs;
	
	public Hooks(TestContextSetup tcs)
	{
		this.tcs=tcs;
	}
	
	@After
	public void AfterScenario() throws IOException
	{
		tcs.testBase.WebDriverManager().quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver=tcs.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
			File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContents=FileUtils.readFileToByteArray(Source);
			scenario.attach(fileContents, "image/png", "image");
		}
	}
}
