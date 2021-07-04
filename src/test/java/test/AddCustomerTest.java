package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.AddCustomerPage;
import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {
	WebDriver driver;

//	@Test
//	@Parameters({ "username", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "Country",
//			"State", "Zip" })
//	public void ValidUserShouldBeAbleToCreateCustomer(String username, String password, String FullName,
//			String CompanyName, String Email, String Phone, String Address, String City, String Country, String State,
//			String Zip) {
//		driver = BrowserFactory.init();
//
//		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
//		loginpage.UserName(username);
//		loginpage.Password(password);
//		loginpage.Login();
//
//		DashboardPage Dp = PageFactory.initElements(driver, DashboardPage.class);
//		Dp.verifyDashboardPage();
//		Dp.clickonCustomer();
//		Dp.clickonAddCustomer();
//
//		AddCustomerPage AddCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
//		AddCustomer.enterfullname(FullName);
//		AddCustomer.enterCompany(CompanyName);
//		AddCustomer.enterEmail(Email);
//		AddCustomer.enterPhone(Phone);
//		AddCustomer.enterAddress(Address);
//		AddCustomer.enterCity(City);
//		AddCustomer.enterState(State);
//		AddCustomer.enterZip(Zip);
//		AddCustomer.entercountry(Country);
//		AddCustomer.clickonSaveButton();
//		AddCustomer.VerifySummaryPage();
//
//		Dp.ClickonListCustomer();
//		AddCustomer.VerifyEnteredNameAndDelete();
//
//		BrowserFactory.teardown();
//	}

	@Test
	@Parameters({ "username", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "Country",
			"State", "Zip" })
	public void ValidUserShouldBeAbleToUseAddCustomerOnListCustomer(String username, String password, String FullName,
			String CompanyName, String Email, String Phone, String Address, String City, String Country, String State,
			String Zip) {
		driver = BrowserFactory.init();

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.UserName(username);
		loginpage.Password(password);
		loginpage.Login();

		DashboardPage Dp = PageFactory.initElements(driver, DashboardPage.class);
		Dp.verifyDashboardPage();
		Dp.clickonCustomer();
		Dp.ClickonListCustomer();

		AddCustomerPage AddCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
		AddCustomer.AddCustomerListCustomer();
		AddCustomer.enterfullname(FullName);
		AddCustomer.enterCompany(CompanyName);
		AddCustomer.enterEmail(Email);
		AddCustomer.enterPhone(Phone);
		AddCustomer.enterAddress(Address);
		AddCustomer.enterCity(City);
		AddCustomer.enterState(State);
		AddCustomer.enterZip(Zip);
		AddCustomer.entercountry(Country);
		AddCustomer.clickonSaveButton();
		AddCustomer.VerifySummaryPage();

		Dp.ClickonListCustomer();
		
		
		AddCustomer.insertnameonsearchbar();
		AddCustomer.verifysummaryandSearchBarButton();
		AddCustomer.VerifySummaryPage();

	}
}