package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	ExcelReader exlreader = new ExcelReader(".\\data\\Techfios.xlsx");
	String UserName = exlreader.getCellData("LoginInfo", "UserName", 2);
	String Password = exlreader.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void ValidUserShouldBeAbleToLogin() {
		driver = BrowserFactory.init();

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.UserName(UserName);
		loginpage.Password(Password);
		loginpage.Login();

		DashboardPage Dp = PageFactory.initElements(driver, DashboardPage.class);
		Dp.verifyDashboardPage();

		BrowserFactory.teardown();
	}
}
