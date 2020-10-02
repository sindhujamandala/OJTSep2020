package driverScript;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonFunLibrary.InterviewTcOne;
import CommonFunLibrary.InterviewTcTwo;

public class DriverScriptForTC2 {


	@BeforeTest
	public void setup() throws Throwable
	{
		String applaunch = InterviewTcOne.verifyUrl("http://www.msn.com/en-in/weather/today/New-Delhi,Delhi,India/we-city-28.608,77.201?iso=IN");
		Reporter.log(applaunch,true);
	}
	@Test(priority=0)
	public void fbWindow()
	{
		InterviewTcTwo.fbLike();
	}
	@Test(priority=1)
	public void twitterWindow()
	{
		InterviewTcTwo.twitter();
	}
	@Test(priority=2)
	public void verifyTemperature()
	{
		InterviewTcTwo.temperature("Bengaluru");
	}
	@AfterTest
	public void tearDown()
	{
		InterviewTcOne.closeBrowser();
	}
}


