package core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
	
	WebDriver driver;
	String baseUrl = "http://alex.academy/exercises/signup/v1/";

	public BasePage(WebDriver wd) {
		driver = wd;
	}
	
	public void get_Url(String first_name, String last_name, String email, String phone) 
	{System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver");
	driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(baseUrl);
	driver.getTitle();
	driver.findElement(By.id("id_fname")).sendKeys(first_name); 
	driver.findElement(By.id("id_lname")).sendKeys(last_name); 
 	driver.findElement(By.id("id_email")).sendKeys(email); 
 	driver.findElement(By.id("id_phone")).sendKeys(phone); 
	}
	
 	public void Confirmation()
 	{
 	driver.findElement(By.id("id_submit_button")).click();
 	driver.getTitle();
	}
	
	
	public void close()
	{
		//driver.quit();
	}

	}		
