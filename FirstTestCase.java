package automationFramework;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTestCase {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		 driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		 
		 FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		 wait.pollingEvery(250,  TimeUnit.MILLISECONDS);
		 wait.withTimeout(2, TimeUnit.SECONDS);
		 
		 Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>()
		 {
		 public Boolean apply(WebDriver arg0) {
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
		 
		 wait.until(function);
 

	}
}