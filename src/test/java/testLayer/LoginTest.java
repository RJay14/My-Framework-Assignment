package testLayer;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackage.BaseHRMClass;
import POM.POMLogin;
import testData.ExcelSheet;

public class LoginTest extends BaseHRMClass {
	
	POMLogin Log;
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void initsetup() {
		initiation();
		Log = new POMLogin();
		//screenshots("Login");
	}
	
	@Test (priority=1)
	public void Title(){
		String actual = Log.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "OrangeHRM");
	}
	
	@DataProvider
	public Object[][] Details(){
		Object result[][]=ExcelSheet.readdata("Sheet1");
		return result;
	}

	
	@Test (priority=2, dataProvider="Details")
	public void Login(String name, String password) throws InterruptedException {
		/* Below used to fetch data from configuration file
		Log.typeusername(prop.getProperty("username"));
		Log.typepassword(prop.getProperty("password"));*/
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Log.typeusername(name);
		Log.typepassword(password);
		Thread.sleep(3000);
		Log.clickbutton();
	}
	
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(3000);
		screenshots("Login");
		driver.close();
	}

}
