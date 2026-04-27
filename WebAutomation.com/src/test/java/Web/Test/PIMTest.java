package Web.Test;

import Base.BaseTest;
import Base.PropertyReaderFile;
import PageObject.LoginPage;
import PageObject.PIMPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PIMTest extends BaseTest {
	LoginPage loginpage;

    private PIMPage pimPage;

    @BeforeMethod
    public void initializePIMPage() {
        pimPage = new PIMPage(driver);
    }

   
    @Test(description = "Verify user can click on PIM menu")
    public void testClickPIMMenu() {
    	loginpage = new LoginPage(driver);
		String pagetitle = loginpage.login(PropertyReaderFile.get("username"), PropertyReaderFile.get("password"));
        pimPage.clickPIMMenu();
        Assert.assertTrue(pimPage.isAddEmployeeHeaderDisplayed(), "PIM menu should be accessible");
    }

   

}
