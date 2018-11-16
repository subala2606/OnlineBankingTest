package Automation.Tisting.OnlineBankingTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JUnitExample {
	
	@Before
	public void setup() {
		System.out.println("setup method called");
		
	}
	@Test
	public void Test1() {
		System.out.println("Test1 method called");
		
	}
	@Test
	public void Test2() {
		System.out.println("Test2 method called");
		
	}
	@Test
	public void Test3() {
		System.out.println("Test3 method called");
		
	}
	@After
	public void TearDown() {
		System.out.println("TearDown method called");
		
	}
}
