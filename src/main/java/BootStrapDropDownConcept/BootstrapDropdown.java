package BootStrapDropDownConcept;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropdown {
	public static WebDriver driver;
	
	/*
	 * How to handle Bootstrap DropDown in Selenium :
		• How to handle different styles of bootstrap down
		• Click on the given dropdown
		• Get all the tags while are available under "li" tag
		• Get the text of each "li//a" OR "div//a"
		• Match the text and click on it
*/	
	
	
	public static void main(String[] args) {

	/*	ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--headless");
	*/	WebDriverManager.chromedriver().version("2.40").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_3");
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label"));
		
		System.out.println(list.size());
		
		//for all item
		/*for(WebElement items : list)
		{			System.out.println(items.getText());
			items.click();
			
		}*/
		
		
		// particular item
		for(WebElement items : list)
		{
			System.out.println(items.getText());
			if(items.getText().contains("Angular"))
				items.click();
			break;
		}
		
	}

}
