package Web.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Base.PropertyReaderFile;
import PageObject.LoginPage;

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
