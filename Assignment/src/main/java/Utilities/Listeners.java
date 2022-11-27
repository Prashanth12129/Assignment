package Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener 
{
	
	
	WebDriver driver ; 
	
	
	
	public void onTestStart(ITestResult result) 
	{
				
		System.out.println(" ------------- Test case execution Started " + result.getMethod().getMethodName() + " --------- ");
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		
		System.out.println(" ------------- Test case execution Sucess " + result.getMethod().getMethodName() + " --------- ");
	}
	
	public void onTestFailure(ITestResult result) 
	{
				
		System.out.println(" ------------- Test case execution failed " + result.getMethod().getMethodName() + " --------- "); 
		
						
	}
	
	public void onTestSkipped(ITestResult result) 
	{
		
		System.out.println(" ------------- Test case execution Skipped " + result.getMethod().getMethodName() + " --------- ");
	}
	
	public void onStart(ITestContext context) 
	{
		
		System.out.println(" ------------- Test case execution Started " + context.getName()+ " --------- ");
	}
	
	public void onFinish(ITestContext context)
	{
			
		System.out.println(" ------------- Test case execution finished " + context.getName()+ " --------- ");
	}
}




