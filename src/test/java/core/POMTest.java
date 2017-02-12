package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMTest {
	
	
	BasePage function = new BasePage(driver);
	static WebDriver driver = new FirefoxDriver();
	
	@BeforeMethod
	public void before() throws Exception {function.get_Url("Ruth", "Smith", "ts@m.com", "9898989898");}
	
	@AfterMethod
	public void after() throws Exception {function.close();}
	
	@Test
	public void test_01_applicationTitle(){ AssertJUnit.assertTrue("Failure", function.driver.getTitle().contains ("Welcome to Sign Up v1"));}
	
	@Test
	public void test_02_Confirmation(){ AssertJUnit.assertTrue("Failure", function.driver.getTitle().contains ("Confirmation"));}
	
}
