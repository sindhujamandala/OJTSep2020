package driverScript;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonFunLibrary.InterviewTcOne;

public class DriverScriptForTC1 {

	@BeforeTest
	public void setup() throws Throwable
	{
		String applaunch = InterviewTcOne.verifyUrl("http://www.msn.com/en-in/weather/today/New-Delhi,Delhi,India/we-city-28.608,77.201?iso=IN");
		Reporter.log(applaunch,true);
	}
	@Test(priority=0)
	public void weatherToTravel()
	{
		InterviewTcOne.clickTravelFromWeather();
	}

	@Test(priority=1)
	public void lifeStyleToTravel()
	{
		InterviewTcOne.clickTravelFromLifeStyle();
	}
	@Test(priority=2)
	public void flightSearch()
	{
		InterviewTcOne.flightSearch();
		InterviewTcOne.selectOrigin("Delhi");
		InterviewTcOne.selectDest("Chennai");
		InterviewTcOne.selectDepartDate();
		InterviewTcOne.selectReturnDate();
		InterviewTcOne.passengers("2","1");
		InterviewTcOne.price();
		InterviewTcOne.backToLifeStyle();
	}	

	@AfterTest
	public void tearDown()
	{
		InterviewTcOne.closeBrowser();
	}


}
