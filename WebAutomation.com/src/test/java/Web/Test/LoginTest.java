package Web.Test;

import org.testng.annotations.Test;

import base.BaseTest;
import base.PropertyReaderFile;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import models.ConfigJson;
import pages.LoginPage;
import utils.JsonReader;




//@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseTest{
	
	
	LoginPage loginpage;
	@Description("Verify user can login successfully")
	@Test(priority = 0)
	public void login() {
		loginpage = new LoginPage(driver);
		boolean Loginpagedisplay = loginpage.isLoginPageDisplayed();
		Assert.assertEquals(Loginpagedisplay, true);
		String pagetitle = loginpage.login(PropertyReaderFile.get("username"), PropertyReaderFile.get("password"));
		Assert.assertEquals(pagetitle, "OrangeHRM");
		loginpage.clickLogout();
		Assert.assertEquals(pagetitle, "OrangeHRM");
	}
	
	@Description("Verify user can't login successfully using invalid username")
	@Test(priority = 1)
	public void InvalidUserNameLogin() {
		loginpage = new LoginPage(driver);
		boolean Loginpagedisplay = loginpage.isLoginPageDisplayed();
		Assert.assertEquals(Loginpagedisplay, true);
		String pagetitle = loginpage.login(PropertyReaderFile.get("invalidusername"), PropertyReaderFile.get("password"));
		Assert.assertEquals(pagetitle, "OrangeHRM");
		
		
	}
	
	@Description("Verify user can't login successfully using invalid username")
	//@Test(priority = 2)
	public void InvalidPasswordLogin() {
		loginpage = new LoginPage(driver);
		boolean Loginpagedisplay = loginpage.isLoginPageDisplayed();
		Assert.assertEquals(Loginpagedisplay, true);
		String pagetitle = loginpage.login(PropertyReaderFile.get("username"), PropertyReaderFile.get("invalidpassword"));
		Assert.assertEquals(pagetitle, "OrangeHRM");
		
		
	}
	

}
