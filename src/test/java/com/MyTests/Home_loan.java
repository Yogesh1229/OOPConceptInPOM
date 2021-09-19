package com.MyTests;


import org.testng.annotations.Test;

public class Home_loan {

	@Test(timeOut = 200)  
	public void testcase1()  
	{  
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println("HR");  
	}  
	
	@Test(timeOut = 300)  
	public void testcase2()  
	{  

	System.out.println("Software Developer");  
	}  
	
	@Test()  
	public void testcase3()  
	{  
	System.out.println("QA Analyst");  
	}  
	
	@Test
	public void MobileLoginHomeLoan() {
		System.out.println("Mobile Login Home Loan");
	}

	@Test
	public void APILoginHomeLoan() {
		System.out.println("API Login Home Loan");
	}
}
