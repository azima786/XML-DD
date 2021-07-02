package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	WebDriver driver;
	String enteredName;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FullName;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement Company;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement Email;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement Phone;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement address;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement city;
	@FindBy(how = How.XPATH, using = "//*[@id=\"state\"]")
	WebElement state;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement zip;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement country;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SAVE_BUTTON_ON_ADD_CONTACTS;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]")
	WebElement SUMMARY_BUTTON_SUMMARY_PAGE;

	public void enterfullname(String fullname) {
		enteredName = (randomnumber(999) + fullname);
		FullName.sendKeys(randomnumber(999) + fullname);
	}

	public void enterCompany(String company) {
		selectDropdown(Company, company);
	}

	public void enterEmail(String email) {
		Email.sendKeys(randomnumber(999) + email);
	}

	public void enterPhone(String phone) {
		Phone.sendKeys(randomnumber(999) + phone);
	}

	public void enterAddress(String Address) {
		address.sendKeys(Address);
	}

	public void enterCity(String City) {
		city.sendKeys(City);
	}

	public void enterState(String State) {
		state.sendKeys(State);
	}

	public void enterZip(String Zip) {
		zip.sendKeys(Zip);
	}

	public void entercountry(String Country) {
		country.sendKeys(Country);
	}

	public void clickonSaveButton() {
		SAVE_BUTTON_ON_ADD_CONTACTS.click();
	}

	public void VerifySummaryPage() {

		WaitforElement(driver, 10, SUMMARY_BUTTON_SUMMARY_PAGE);
		Assert.assertEquals(SUMMARY_BUTTON_SUMMARY_PAGE.getText(), "Summary", "Wrong Page!!!");
	}

	public void VerifyEnteredNameAndDelete() {

		String BeforeXPath = "//tbody/tr[";
		String AfterPath = "]/td[3]";

		for (int i = 1; i <= 10; i++) {
			String name = driver.findElement(By.xpath(BeforeXPath + i + AfterPath)).getText();
//			System.out.println(name);
//			Assert.assertEquals(name, enteredName, "Wrong");
//			break;
			
			if(name.contains(enteredName)) {
				System.out.println("Entered name exist");
				driver.findElement(By.xpath(BeforeXPath + i + "]/td[7]/a[2]")).click();
		
					
			}
		}}}
	

	

