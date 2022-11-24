package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseHRMClass;

public class POMLogin extends BaseHRMClass{
	
	@FindBy(id="txtUsername")WebElement Username;
	@FindBy(id="txtPassword")WebElement Password;
	@FindBy(id="btnLogin") WebElement Loginbtn;
	
	public POMLogin() {
		PageFactory.initElements(driver, this);
	}
	
	public void typeusername(String name) {
		Username.sendKeys(name);
	}
	
	public void typepassword(String pass) {
		
		Password.sendKeys(pass);
	}
	
	public void clickbutton() {
		Loginbtn.click();
	}
	
	public String verify() {//verifies the title of the page
		return driver.getTitle();
	}
}
