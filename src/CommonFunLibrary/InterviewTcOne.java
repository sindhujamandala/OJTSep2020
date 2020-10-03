package CommonFunLibrary;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class InterviewTcOne {

	public static WebDriver driver;
	public static Actions act;
	

	//Verify the url launch
	public static String verifyUrl(String url)
	{
		String res ="";
		System.setProperty("webdriver.chrome.driver", "E:\\selenium programs\\SindhujaMandala-V0.3-270920\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		if(driver.findElement(By.linkText("weather")).isDisplayed())
		{
			res= " App launch success";
		}
		else
		{
			res = "App Launch fail";
		}
		return res;
	}
	//Navigate to Travel from weather
	public static void clickTravelFromWeather()
	{
		driver.findElement(By.linkText("weather")).click();
		act = new Actions(driver);
		WebElement element1 = driver.findElement(By.xpath("//li[@class='travel']//a[contains(text(),'Travel')]"));
		act.moveToElement(element1).click();
		act.build().perform();
	}
	//Navigate to travel from Lifestyle
	public static void clickTravelFromLifeStyle()
	{
		driver.findElement(By.partialLinkText("lifesty")).click();
		WebElement element2 =driver.findElement(By.xpath("//div[@class='list7lines']//a[contains(text(),'Travel')]"));
		act.moveToElement(element2).click();
		act.build().perform();
	}
	//Navigate to flight search
	public static void flightSearch()
	{
		driver.findElement(By.linkText("lifestyle")).click();
		WebElement element3 = driver.findElement(By.linkText("Flight Search"));
		act.moveToElement(element3).click();
		act.build().perform();
	}
	//select origin location
	public static void selectOrigin(String origin)
	{
		WebElement org =driver.findElement(By.xpath("//input[@placeholder='Origin city or airport']"));
		org.clear();
		org.sendKeys(origin);
		org.sendKeys(Keys.ENTER);
	}
	//select destination location
	public static void selectDest(String destination)
	{
		WebElement dest = driver.findElement(By.xpath("//input[@placeholder='Destination city or airport']"));
		dest.clear();
		dest.sendKeys(destination);
		dest.sendKeys(Keys.ENTER);
	}
	//select start date
	public static String selectDepartDate()
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calen = Calendar.getInstance();
		System.out.println("Current Date: "+sdf.format(calen.getTime()));
		calen.add(Calendar.DAY_OF_MONTH, 10);  
		String departDate = sdf.format(calen.getTime());  
		System.out.println("Date of departure: "+departDate);
		
		String[] temp=departDate.split("/");
		String day=temp[0];
		String month=temp[1];
		String year=temp[2];
		
		driver.findElement(By.xpath("(//button[@class='search-date-cover'])[1]")).click();
		driver.findElement(By.xpath("//*[@id='date-depart_root']/div/div/div/div/div[2]/div[1]/div/div/ul")).click();
		List<WebElement> monthYear = driver.findElement(By.xpath("//*[@id='date-depart_root']/div/div/div/div/div[2]/div[1]/div/div/ul")).findElements(By.tagName("li"));
		boolean flag=false;
		for(int i=0;i<monthYear.size();i++)
		{
			String yearandmonth= monthYear.get(i).getText();
			String[] ym=yearandmonth.split(" ");
			if((ym[0].equals(month)) && (ym[1].equals(year)))
			{
				monthYear.get(i).click();
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Depart Month is choosen is:"+month+"Depart Year choosen is:"+year);
		}
		else
		{
			System.out.println("Choosen month and year are incorrect");
		}

		WebElement cal=driver.findElement(By.id("date-depart_table"));

		List<WebElement> rows,cols;

		rows=cal.findElements(By.tagName("tr"));
		boolean fla=false;
		for(int j=1;j<rows.size();j++)
		{
			cols=rows.get(j).findElements(By.tagName("td"));
			for(int k=0;k<cols.size();k++)
			{
				String caldt=cols.get(k).getText();
				if(caldt.equals(day))
				{
					cols.get(k).click();
					flag=true;
					break;
				}
			}
			if(flag)
			{
				break;
			}
		}
		return departDate;
	}
	//select return date
	public static String selectReturnDate()
	{		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calen = Calendar.getInstance();
		System.out.println("Departure date "+sdf.format(calen.getTime()));
		calen.add(Calendar.DAY_OF_MONTH, 15);  
		String returnDate = sdf.format(calen.getTime());  
		System.out.println("Date of return: "+returnDate);
		String[] tempo=returnDate.split("/");
		String returnDay=tempo[0];
		String returnMonth=tempo[1];
		String returnYear=tempo[2];
		
		driver.findElement(By.xpath("//button[@class='button-reset js-dropdown-toggle js-header-container dropdown-toggle selected']")).click();
		driver.findElement(By.xpath("//*[@id='date-return_root']/div/div/div/div/div[2]/div[1]/div/div/ul")).click();
		List<WebElement> monthYear = driver.findElement(By.xpath("//*[@id='date-return_root']/div/div/div/div/div[2]/div[1]/div/div/ul")).findElements(By.tagName("li"));
		boolean flag=false;
		for(int a=0;a<monthYear.size();a++)
		{
			String yearandmonth= monthYear.get(a).getText();
			String[] ym=yearandmonth.split(" ");
			if((ym[0].equals(returnMonth)) && (ym[1].equals(returnYear)))
			{
				monthYear.get(a).click();
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Return Month is choosen is:"+returnMonth+"Return Year choosen is:"+returnYear);
		}
		else
		{
			System.out.println("Choosen month and year are incorrect");
		}

		WebElement cal=driver.findElement(By.id("date-depart_table"));

		List<WebElement> rows,cols;

		rows=cal.findElements(By.tagName("tr"));
		boolean fla=false;
		for(int b=1;b<rows.size();b++)
		{
			cols=rows.get(b).findElements(By.tagName("td"));
			for(int c=0;c<cols.size();c++)
			{
				String caldt=cols.get(c).getText();
				if(caldt.equals(returnDay))
				{
					cols.get(c).click();
					flag=true;
					break;
				}
			}
			if(fla)
			{
				break;
			}
		}
		return returnDate;
	}

	//select passengers
	public static void passengers(String adult,String child)
	{
		driver.findElement(By.xpath("//button[@aria-label='Number of passengers above 12 years old']")).click();
		WebElement elementAdult = driver.findElement(By.className("dropdown-items js-dropdown-container-wrapper active"));
		List<WebElement> adultpass = elementAdult.findElement(By.tagName("ul")).findElements(By.tagName("li"));
		for(int i=0;i<adultpass.size();i++)
		{
			String noOfAdults =adultpass.get(i).getText();
			if(noOfAdults.equalsIgnoreCase(adult))
			{
				adultpass.get(i).click();
			}
		}

		//Selecting child passengers
		driver.findElement(By.xpath("//button[@aria-label='Number of passengers under 12 years old']")).click();
		WebElement elementInfant = driver.findElement(By.className("dropdown-items js-dropdown-container-wrapper active"));
		List<WebElement> childPass = elementInfant.findElement(By.tagName("ul")).findElements(By.tagName("li"));
		for(int j=0;j<childPass.size();j++)
		{
			String noOfChild = childPass.get(j).getText();
			if(noOfChild.equalsIgnoreCase(child))
			{
				childPass.get(j).click();
			}
		}


		//click on search
		driver.findElement(By.xpath("//a[@aria-label='Search']")).click();
	}
	//print the price
	public static void price()
	{
		String price ;
		WebElement el=driver.findElement(By.xpath("//div[@class='js-itinerary-list-container']"));	
		List<WebElement> ele=el.findElements(By.xpath("//div"));
		price = ele.get(0).findElement(By.className("price-text")).getText();
		System.out.println(price);

	}
	//Navigate back to lifestyle
	public static void backToLifeStyle()
	{
		driver.findElement(By.linkText("back to lifestyle")).click();
	}
	//close browser
	public static void closeBrowser()
	{
		driver.close();
	}
	
	public void verify()
	{
		System.out.println("verify method");
	}

}
