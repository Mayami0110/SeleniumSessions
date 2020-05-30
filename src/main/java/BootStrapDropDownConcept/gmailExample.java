package BootStrapDropDownConcept;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class gmailExample {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		////*[@id="lang-chooser"]/div[@jsname='LgbsSe']//div
		
		
		WebDriverManager.chromedriver().version("2.40").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.gmail.com");
		
		driver.findElement(By.xpath("//div[@jsname='LgbsSe'  and @role='presentation']")).click();
		
		Thread.sleep(3000);
		
		List<WebElement> languages = driver.findElements(By.xpath("//div[@jsname='LgbsSe']//div//span"));

		System.out.println(languages.size());
		
		for(WebElement lang : languages)
		{
			System.out.println(lang.getText());
			if(lang.getText().contains("‪‪eesti"))
				lang.click();
		}
		
		
	}

}
