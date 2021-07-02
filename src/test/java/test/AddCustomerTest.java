package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AddCustomerPage;
import pages.DashboardPage;
import pages.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
WebDriver driver;
ExcelReader exlreader = new ExcelReader(".\\data\\Techfios.xlsx");
String UserName = exlreader.getCellData("LoginInfo", "UserName", 2);
String Password = exlreader.getCellData("LoginInfo", "Password", 2);
String FullName = exlreader.getCellData("Customer", "FullName", 2);
String CompanyName = exlreader.getCellData("Customer", "CompanyName", 2);
String Email = exlreader.getCellData("Customer", "Email", 2);
String Phone = exlreader.getCellData("Customer", "Phone", 2);
String Address = exlreader.getCellData("Customer", "Address", 2);
String City = exlreader.getCellData("Customer", "City", 2);
String Country = exlreader.getCellData("Customer", "Country", 2);
String State = exlreader.getCellData("Customer", "State", 2);
String Zip = exlreader.getCellData("Customer", "Zip", 2);

	
	@Test
	public void ValidUserShouldBeAbleToCreateCustomer() {
	driver = BrowserFactory.init();
	
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	loginpage.UserName(UserName);
	loginpage.Password(Password);
	loginpage.Login();
	
	DashboardPage Dp = PageFactory.initElements(driver, DashboardPage.class);
	Dp.verifyDashboardPage();
	Dp.clickonCustomer();
	Dp.clickonAddCustomer();
	
	AddCustomerPage AddCustomer = PageFactory.initElements(driver, AddCustomerPage.class);
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
	Dp.ClickonlistCustomer();
	
	AddCustomer.VerifyEnteredNameAndDelete();
	
	BrowserFactory.teardown();
	
	}
}
