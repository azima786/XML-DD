package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	WebDriver driver;
	

	@Test
	@Parameters({"username", "password"})
	public void ValidUserShouldBeAbleToLogin(String username, String password) {
		driver = BrowserFactory.init();

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.UserName(username);
		loginpage.Password(password);
		loginpage.Login();

		DashboardPage Dp = PageFactory.initElements(driver, DashboardPage.class);
		Dp.verifyDashboardPage();

		BrowserFactory.teardown();
	}
}
