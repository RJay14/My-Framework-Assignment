package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BasePackage.BaseHRMClass;

public class POMLogin extends BaseHRMClass{
	
	@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")WebElement Username;
	@FindBy(xpath ="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")WebElement Password;
	@FindBy (xpath ="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")WebElement Loginbtn;
	
	
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
