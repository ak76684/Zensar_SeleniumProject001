package Web.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import base.PropertyReaderFile;
import groovyjarjarantlr4.v4.codegen.model.OutputFile;

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
	
	//@Test
	public void test002() {
		String str ="h$LLO wORLD!";
		String nestr="";
		for(int i =0; i<str.length(); i++) {
			char ch = str.charAt(i);
			String st = String.valueOf(ch);
			if(Character.isDigit(ch)) {
				
				nestr=nestr+st.toUpperCase();
			}else {
				nestr=nestr+st.toLowerCase();
			}
		}
		System.out.println(nestr);
		
	}
	
	@Test
	public void genric() {
//		String parentwin = driver.getWindowHandle();
//		Set<String> win = driver.getWindowHandles();
//		Iterator<String> it = win.iterator();
//		String winnam=it.next();
//		winnam.equals
//		for(String setwin : win) {
//			if(setwin.equals(win)) {
//				driver.switchTo().newWindow(null);
//			}
//			
//		}
//		
//		Select sc = new Select(null);
//		sc.getAllSelectedOptions();
		
//		TakesScreenshot sc =  (TakesScreenshot(driver));
//		File dec=sc.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(dec, dec);
		
		  int[] arr = {10, 25, 5, 40};
		  Arrays.sort(arr);
		  char ch='a';
		  
		  Character.isUpperCase(ch);
		  String st = "";
		  
		  
		
		
	}
	

}
