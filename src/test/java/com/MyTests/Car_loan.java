package com.MyTests;

import org.testng.annotations.Test;

public class Car_loan {

	@Test(groups = { "RegressionTest" })
	public void RegressionTest() {
		System.out.println("Regression Test");
	}

	@Test(groups = { "SmokeTest","RegressionTest" })
	public void SmokeTestAndRegressionTest() {
		System.out.println("Smoke Test And Regression Test");
	}

	@Test(groups = { "SmokeTest" })
	public void SmokeTest() {
		System.out.println("Smoke Test");
	}
}
