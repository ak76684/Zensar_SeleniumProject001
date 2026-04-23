package Web.Test;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Base.BaseTest;
import Base.PropertyReaderFile;

public class Test001 extends BaseTest {
	
	//@Test
	public void Test001() {
		int count=0;
	for(int i =0 ; i<100;i++) {
		String st = String.valueOf(i);
		for(int j =0 ; j<st.length(); j++) {
			if(st.charAt(j)=='9') {
				count=count+1;
			}
		}
	}
	System.out.println(count);
	
	}
	
	@Test
	public void test002() {
		String str ="h$LLO wORLD!";
		String nestr="";
		for(int i =0; i<str.length(); i++) {
			char ch = str.charAt(i);
			String st = String.valueOf(ch);
			if(Character.isLowerCase(ch)) {
				
				nestr=nestr+st.toUpperCase();
			}else {
				nestr=nestr+st.toLowerCase();
			}
		}
		System.out.println(nestr);
		
	}
	
	

}
