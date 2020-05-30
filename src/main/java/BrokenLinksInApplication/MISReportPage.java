package BrokenLinksInApplication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MISReportPage {

	public static WebDriver driver;
	
	static HttpURLConnection connection;

	public static void main(String[] args)  {

		
		WebDriverManager.chromedriver().version("2.40").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://nrega.telangana.gov.in/Nregs/");
		
		List <WebElement> linklist = driver.findElements(By.tagName("a"));
		
		List <WebElement> activeList = new ArrayList<WebElement>();

		
		System.out.println(linklist.size());
		
		for(WebElement ele : linklist)
			
		{
			if(ele.getAttribute("href") != null)
			{
				activeList.add(ele);
			}
		}
		
		System.out.println(activeList.size());
		
		
		logger("Total Links in Page : " + activeList.size());
		
		for(WebElement activelink : activeList)
		{
			
			try {
				connection = (HttpURLConnection) new URL(activelink.getAttribute("href")).openConnection();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			try {
				connection.connect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			String response = null ;
			try {
				response = connection.getResponseMessage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger(activelink.getAttribute("href") + "----->  " + response);

			}
			connection.disconnect();
			System.out.println(activelink.getAttribute("href") + "----->  " + response);
			
			logger(activelink.getAttribute("href") + "----->  " + response);
									
		}
		driver.quit();

			
			
			
			
			
				
			}
		
		
		
			
		
		  public static void logger(String log) 
		    {
		    	
		        BufferedWriter writer = null;
		        try {
		            //create a temporary file
		            String timeLog = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		           // File logFile = new File("Exception");
		            File logFile = new File("F:\\WorkSpace\\TESTProject\\SeleniumSessions\\Log\\Exception");

		            // This will output the full path where the file will be written to...
		            System.out.println(logFile.getCanonicalPath());

		            writer = new BufferedWriter(new FileWriter(logFile, true));
		            
		            String finalLog = log; 
		            writer.newLine();
		            writer.newLine();
		            writer.write(finalLog);
		         

		        } catch (Exception e)
		        {
		            e.printStackTrace();
		        } 
		        finally
		        {
		            try 
		            {
		                // Close the writer regardless of what happens...
		                writer.close();
		            }
		            catch (Exception e)
		            {
		            
		            }
		        }
		    
		}


		
		
		
		
		
		
		
		
		
	}


