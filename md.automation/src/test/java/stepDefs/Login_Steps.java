package stepDefs;

import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.BaseTest;
import pageobjects.LoginPage;

public class Login_Steps extends BaseTest {
	LoginPage loginPage;
	String browser = "";

	@Before
	public void beforeClass() {
		BaseTest.launchBrowser();
		loginPage = new LoginPage();
	}

	@After
	public void afterClass(Scenario scenario) {
		BaseTest.captureScreenShot(scenario);
		BaseTest.closeBrowser();
	}

	@Given("^the user is launch the ECP application$")
	public void the_user_is_launch_the_ECP_application() {
		System.out.println("the_user_is_launch_the_ECP_application executed");

	}

	@When("^User navigate to login Page$")
	public void User_navigate_to_login_Page() {
		Assert.assertEquals(loginPage.isUserNameDisplayed(), true);
	}

	@Then("^the user enters valid userName and Password$")
	public void the_user_enters_valid_userName_and_Password() {
		loginPage.typeUserName("mohan.sridhar@lavu.com");
		loginPage.typePassword("Testing@1234");
	}

	@Then("^the user enters below userName and Password$")
	public void the_user_enters_below_userName_and_Password(DataTable table) throws Throwable {
		List<List<String>> data = table.raw();
		String userName = data.get(1).get(0);
		String password = data.get(1).get(1);
		loginPage.typeUserName(userName);
		loginPage.typePassword(password);
	}

	@Then("^the user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_enters_and(String userName, String password) throws Throwable {
		loginPage.typeUserName(userName);
		loginPage.typePassword(password);
	}

	@And("^the user click on Login button$")
	public void the_user_click_on_Login_button() {
		loginPage.clickOnLoingButton();
	}

	@When("^User navigate to ECP home page$")
	public void User_navigate_to_ECP_home_page() {
		loginPage.clickOnResellers();
	}

}
