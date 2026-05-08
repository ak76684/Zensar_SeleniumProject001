package Web.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.PropertyReaderFile;
import pages.LoginPage;

public class failTC extends BaseTest{
	LoginPage loginpage;
	
	@Test()
	public void loginfail() {
		 loginpage = new LoginPage(driver);
		//ConfigJson ReadJasonData = JsonReader.getTestData("Config.json", ConfigJson.class);
		boolean Loginpagedisplay = loginpage.isLoginPageDisplayed();
		Assert.assertEquals(Loginpagedisplay, true);
		String pagetitle = loginpage.login(PropertyReaderFile.get("username"), PropertyReaderFile.get("password"));
		Assert.assertTrue(false);
	}
}
