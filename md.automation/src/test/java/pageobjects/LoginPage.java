package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BaseTest{
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="submi")
	WebElement submit;
	
	@FindBy(linkText="Resellers")
	WebElement Resellers;
	
	//private WebDriver driver;
	
	public boolean isUserNameDisplayed() {
		return userName.isDisplayed();
	}
 	
	public LoginPage() {
		PageFactory.initElements(driver, this);	
	}
	
	//private WebDriver driver;
	
	public void typeUserName(String userid) {
		userName.sendKeys(userid);
	}
	
	public void typePassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickOnLoingButton() {
		submit.click();
	}
	
	public void clickOnResellers() {
		Resellers.click();
	}
}
