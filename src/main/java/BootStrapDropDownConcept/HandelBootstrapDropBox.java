package BootStrapDropDownConcept;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandelBootstrapDropBox {

	static WebDriver driver;
	
		
		public static void main(String[] args) {

			/*	ChromeOptions opt = new ChromeOptions();
				opt.addArguments("--headless");
			*/	WebDriverManager.chromedriver().version("2.40").setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
				
				driver.findElement(By.id("dropdownMenuButton")).click();
				
				List<WebElement> list = driver.findElements(By.xpath("//div[@class= 'dropdown-menu' and @aria-labelledby='dropdownMenuButton']//a"));

				System.out.println(list.size());
				
				for(WebElement items : list)
				{
					System.out.println(items.getText());
					
					if(items.getText().contains("Another action"))
					{
						items.click();
						break;
					}
					
				}
				
	}

}
