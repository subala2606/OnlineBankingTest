package Automation.Tisting.OnlineBankingTest;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample1 {
	
	@BeforeSuite
	public void Beforesuite() {
		System.out.println("before suite exicuted");
	}
	@BeforeTest
	public void Beforetest() {
		System.out.println("before Test exicuted");
	}
	@BeforeClass
	public void beforeclass() {
		System.out.println("before class is exicuted");	
	}
	
	@BeforeMethod
	public void beroremethod() {
		System.out.println("before method is exicuted");
	}
	@Test
	public void Test1() {
		System.out.println("Test1 is exicuted");
		
	}
	@Test
	public void Test2() {
		System.out.println("Test2 is exicuted");
		
	}
	@Test
	public void Test3() {
		System.out.println("Test3 is exicuted");
		
	}
	@AfterMethod
	public void Aftermethod() {
		System.out.println("after method is exicuted");
	}
	@AfterClass
	public void afterclass() {
		System.out.println("after class is exicuted");	
	}
	@AfterTest
	public void aftertest() {
		System.out.println("after test is exicuted");
	}
	@AfterSuite
	public void Aftersuite() {
		System.out.println("After suite exicuted");
	
	 }
}
