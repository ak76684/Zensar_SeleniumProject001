package Web.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import Base.PropertyReaderFile;
import Models.ConfigJson;
import PageObject.LoginPage;
import Util.JsonReader;

public class LoginTest extends BaseTest{
	
	LoginPage loginpage;
	@Test
	public void login() {
		 loginpage = new LoginPage(driver);
		//ConfigJson ReadJasonData = JsonReader.getTestData("Config.json", ConfigJson.class);
		boolean Loginpagedisplay = loginpage.isLoginPageDisplayed();
		Assert.assertEquals(Loginpagedisplay, true);
		String pagetitle = loginpage.login(PropertyReaderFile.get("username"), PropertyReaderFile.get("password"));
	}
	
	@AfterMethod
	public void logout() {
		
		loginpage.clickLogout();
		boolean Loginpagedisplay = loginpage.isLoginPageDisplayed();
		Assert.assertEquals(Loginpagedisplay, true);
	}
	

}
