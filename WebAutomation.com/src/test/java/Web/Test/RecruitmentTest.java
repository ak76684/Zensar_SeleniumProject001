package Web.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import base.PropertyReaderFile;
import pages.LoginPage;
import pages.RecruitmentPage;


@Listeners(listeners.TestListener.class)
public class RecruitmentTest extends BaseTest {
	LoginPage loginpage;
	@Test
	public void US125581SearchCandidatesAndValidate() {
		loginpage = new LoginPage(driver);
		String pagetitle = loginpage.login(PropertyReaderFile.get("username"), PropertyReaderFile.get("password"));
	RecruitmentPage recruitment=new RecruitmentPage(driver);
	recruitment.clickOnRecruitment();
	recruitment.selectFromDropdown( "Job Title", "QA Lead");
    recruitment.selectFromDropdown("Vacancy", "Senior QA ead");
    //recruitment.selectFromDropdown("Hiring Manager", "Anurag user");
   // recruitment.selectFromDropdown("Status", "Shortlisted");
    recruitment.enterValueInCandidateNameFieldAndValidate("xyz");
   // recruitment.selectDate();
    recruitment.clickSearchAndvalidate();
    
}
}
