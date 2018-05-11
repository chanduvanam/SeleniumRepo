package Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

public class SyncClass {
	
	
	@SuppressWarnings("unchecked")
	public boolean gFunc_WaitForobjectExistance()
	{
	boolean blnStatus = false;
	try
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Browser.getDriver());
		wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		wait.withTimeout(2, TimeUnit.SECONDS);
 
		Function<WebElement, Boolean> function = new Function<WebElement, Boolean>()
				{
					public Boolean apply(WebElement arg0) {
						WebElement element = arg0.findElement(By.id("colorVar"));
						String color = element.getAttribute("color");
						System.out.println("The color if the button is " + color);
						if(color.equals("red"))
						{
							return true;
						}
						return false;
					}
				};
 
		wait.until((Predicate<WebDriver>) function);
	}
	catch(Exception e)
	{
		
	}
	return blnStatus;
	}

}
