package Web.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Base.PropertyReaderFile;
import PageObject.LoginPage;
import PageObject.RecruitmentPage;


public class RecruitmentTest extends BaseTest {
	LoginPage loginpage;
	@Test
	public void US125581SearchCandidatesAndValidate() {
		loginpage = new LoginPage(driver);
		String pagetitle = loginpage.login(PropertyReaderFile.get("username"), PropertyReaderFile.get("password"));
	RecruitmentPage recruitment=new RecruitmentPage(driver);
	recruitment.clickOnRecruitment();
	recruitment.selectFromDropdown( "Job Title", "QA Lead");
    recruitment.selectFromDropdown("Vacancy", "Senior QA Lead");
    //recruitment.selectFromDropdown("Hiring Manager", "Anurag user");
   // recruitment.selectFromDropdown("Status", "Shortlisted");
    recruitment.enterValueInCandidateNameFieldAndValidate("xyz");
   // recruitment.selectDate();
    recruitment.clickSearchAndvalidate();
    
}
}
