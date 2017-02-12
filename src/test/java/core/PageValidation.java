package core;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class PageValidation {
	WebDriver driver;
	
	
	static String baseUrl  = "http://alex.academy/exercises/signup/v1/";
	String first_name = "Alex";
	String last_name = "Smith";
	String last_name_error = "Wu";
	String email = "ts@m.com";
	String phone = "9898989898";
	
	@BeforeMethod
	
	public void beforeMethod() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
	@AfterMethod
	public void afterMethod() throws Exception {
		driver.quit();
	}
	
	
	@Test
	public void test_01_application_title(){
		
		AssertJUnit.assertTrue("Failure", (driver.getTitle().contains ("Sign Up")));
	}
	
	@Test
	public void test_02_page_title(){
		
		AssertJUnit.assertTrue("Failure", driver.findElement(By.id("id_f_title")).getText().contains ("Sign Up"));
	}
	
	@Test
	public void test_03_verify_content() {
		
	try{ 
		driver.findElement(By.id("id_current_location"));
		System.out.println(true);
		}
	catch (NoSuchElementException e) {
		System.out.println(false);
		}
	try{ 
		driver.findElement(By.id("id_quotes"));
		System.out.println(true);
		}
	catch (NoSuchElementException e) {
		System.out.println(false);
		}
	try{ 
		driver.findElement(By.id("id_temperature"));
		System.out.println(true);
		}
	catch (NoSuchElementException e) {
		System.out.println(false);
		}
	try{ 
		driver.findElement(By.id("copyright"));
		System.out.println(true);
		}
	catch (NoSuchElementException e) {
		System.out.println(false);
		}
	try{ 
		driver.findElement(By.id("timestamp"));
		System.out.println(true);
		}
	catch (NoSuchElementException e) {
		System.out.println(false);
		}
	try{ 
		driver.findElement(By.id("os_browser")).getText();
		System.out.println(true);
		}
	catch (NoSuchElementException e) {
		System.out.println(false);
		}
	}
	
	
	@Test
	public void test_04_verify_links() throws InterruptedException{
		
		if(driver.findElement(By.id("id_img_facebook")).isEnabled())
		{
		System.out.println("Facebook is clickable");
		}
		else
		{
		System.out.println("Element is not clickable");
		}
		if(driver.findElement(By.id("id_img_twitter")).isEnabled())
		{
		System.out.println("Twitter is clickable");
		}
		else
		{
		System.out.println("Element is not clickable");
		}
		if(driver.findElement(By.id("id_img_flickr")).isEnabled())
		{
		System.out.println("Flickr is clickable");
		}
		else
		{
		System.out.println("Element is not clickable");
		}
		if(driver.findElement(By.id("id_img_youtube")).isEnabled())
		{
		System.out.println("YouTube is clickable");
		}
		else
		{
		System.out.println("Element is not clickable");
		}
	}
	
	@Test
	public void  test_05_error_handling_LastName() throws InterruptedException{
 		
 	driver.findElement(By.id("id_fname")).sendKeys(first_name); 
 	driver.findElement(By.id("id_lname")).sendKeys(last_name_error); 
 	driver.findElement(By.id("id_email")).sendKeys(email); 
 	driver.findElement(By.id("id_phone")).sendKeys(phone); 
 	driver.findElement(By.id("id_submit_button")).click();

 	Thread.sleep(1_000L);
 	
 	AssertJUnit.assertTrue("Failure", driver.findElement(By.id("ErrorLine")).getText().contains("Invalid Last Name"));
 	
	}
	
	@Test
	public void  test_06_verify_submit_form() throws InterruptedException{
 		
 	AssertJUnit.assertTrue("Failure", driver.getPageSource().contains("fname"));
 	AssertJUnit.assertTrue("Failure", driver.getPageSource().contains("lname"));
 	AssertJUnit.assertTrue("Failure", driver.getPageSource().contains("email"));
 	AssertJUnit.assertTrue("Failure", driver.getPageSource().contains("phone"));
 	AssertJUnit.assertTrue("Failure", driver.getPageSource().contains("Gender"));
 	AssertJUnit.assertTrue("Failure", driver.getPageSource().contains("state"));
 	AssertJUnit.assertTrue("Failure", driver.getPageSource().contains("label_checkbox"));
 	
	}
	
	@Test
	public void  test_07_verify_confirmation() throws InterruptedException{
 	
 	driver.findElement(By.id("id_fname")).sendKeys(first_name); 
 	driver.findElement(By.id("id_lname")).sendKeys(last_name);
 	driver.findElement(By.id("id_email")).sendKeys(email); 
 	driver.findElement(By.id("id_phone")).sendKeys(phone); 
 	driver.findElement(By.id("id_submit_button")).click();
 
 	Thread.sleep(1_000L);
 	
 	System.out.println(driver.getTitle());
 	AssertJUnit.assertTrue("Failure", (driver.getTitle().contains ("Confirmation")));
 	
}
	
}