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

   
    @Test(priority=1)
    public void testClickPIMMenu() {
    	loginpage = new LoginPage(driver);
		String pagetitle = loginpage.login(PropertyReaderFile.get("username"), PropertyReaderFile.get("password"));
        pimPage.clickPIMMenu();
        Assert.assertTrue(pimPage.isAddEmployeeHeaderDisplayed(), "PIM menu not accessible");
    	pimPage.clickAddEmployee();
        Assert.assertTrue(pimPage.isAddEmployeeHeaderDisplayed(), "Add Employee page not  displayed");
    }
    
    @Test(enabled=false)
    public void testAddEmployeeWithBasicDetails() {
        //pimPage.clickPIMMenu();
       // pimPage.clickAddEmployee();
        
        pimPage.enterFirstName("John");
        pimPage.enterMiddleName("Michael");
        pimPage.enterLastName("Dan");
        pimPage.enterEmployeeId("EMP001");
        
        pimPage.clickSave();
        
        Assert.assertTrue(pimPage.isAddEmployeeSectionDisplayed(), "Employee not added");
    }
    
    @Test(priority=2)
    public void testAddEmployeeWithLoginDetailsEnabled() {
        
        pimPage.enterFirstName("Arjun");
        pimPage.enterLastName("kumar");
        pimPage.enterEmployeeId("EMP003");
        
        // Enable login details
        pimPage.setCreateLoginDetails();
        pimPage.enterUsername("arjun");
        pimPage.enterPassword("Password@123");
        pimPage.enterConfirmPassword("Password@123");
      //  pimPage.setCreateLoginDetails();
        pimPage.selectStatusEnabled();
        pimPage.clickSave();
        
        Assert.assertTrue(pimPage.isAddEmployeeSectionDisplayed(), "Employee with login details not added");
    }
    
    @Test(enabled=false)
    public void testAddEmployeeWithLoginDetailsStatusDisabled() {
        
        pimPage.enterFirstName("Varun");
        pimPage.enterLastName("kumar");
        pimPage.enterEmployeeId("EMP004");
        
        // Enable login details
        pimPage.setCreateLoginDetails();
        pimPage.enterUsername("varun");
        pimPage.enterPassword("Password@123");
        pimPage.enterConfirmPassword("Password@123");
      //  pimPage.setCreateLoginDetails();
        pimPage.selectStatusDisabled();
        pimPage.clickSave();
        
        Assert.assertTrue(pimPage.isAddEmployeeSectionDisplayed(), "Employee with login details not added");
    }



    
    
    
   


   

}
