package Web.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Base.PropertyReaderFile;
import Models.ConfigJson;
import PageObject.LoginPage;
import Util.JsonReader;

public class LoginTest extends BaseTest{
	
	@Test
	public void Login() {
		LoginPage loginpage = new LoginPage(driver);
		//ConfigJson ReadJasonData = JsonReader.getTestData("Config.json", ConfigJson.class);
		boolean Loginpagedisplay = loginpage.isLoginPageDisplayed();
		Assert.assertEquals(Loginpagedisplay, true);
		String pagetitle = loginpage.login(PropertyReaderFile.get("username"), PropertyReaderFile.get("password"));
		

	}
	

}
