package CommonFunLibrary;

import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class InterviewTcTwo {

	public static WebDriver driver;
	//open fblike window and close
	public static void fbLike()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element =driver.findElement(By.xpath("//button[contains(@title,'Like')]"));
		js.executeScript("arguments[0].scrollIntoView();", Element);		
		driver.findElement(By.xpath("//button[contains(@title,'Like')]")).click();
		Set<String> allwindows = driver.getWindowHandles();
		Object[] wind = allwindows.toArray();
		String fb = wind[1].toString();
		driver.switchTo().window(fb);
		driver.close();
	}
	//open twitter tab and close
	public static void twitter()
	{
		driver.findElement(By.xpath("//a[@id='follow-button']")).click();
		Set<String> wind = driver.getWindowHandles();
		ArrayList<String> tabs2 = new ArrayList<String>(wind);
		driver.switchTo().window(tabs2.get(1));
		driver.close();
		driver.switchTo().window(tabs2.get(0));
	}

	public static void temperature(String city)
	{

		int delhiTemp=Integer.parseInt(driver.findElement(By.xpath("//span[@class='current']")).getText());
		driver.findElement(By.linkText("Places")).click();
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("(//input[@name='q'])[2]")).sendKeys(city);;
		act.sendKeys(Keys.ARROW_DOWN).click().build().perform();
		String actname=driver.findElement(By.xpath("//div[@class='header']//span")).getText();
		if(actname.contains(city))
		{
			System.out.println("city" +city+ "is selected");
			int city2 = Integer.parseInt(driver.findElement(By.xpath("//span[@class='current']")).getText());
			if(delhiTemp==city2)
			{
				System.out.println("temperatures are equal");
			}
			else if(delhiTemp>city2)
			{
				System.out.println("Delhi Tempertaure" +delhiTemp+" "+"is higher than" +city );
			}
			else
			{
				System.out.println(city+ "temperature is higher than delhi temperature");
			}

		}
		else
		{
			System.out.println("city" +city+ "not selected");
		}


	}
}


