package app.data;


import org.testng.ITestContext;  
import org.testng.ITestListener;  
import org.testng.ITestResult;  
public class TestListener implements ITestListener  {

	
	  
	//@Override  
	public void onTestStart(ITestResult result) {  
	 System.out.println("TestListener.onTestStart()");
	}  
	  
	//@Override  
	public void onTestSuccess(ITestResult result) {  
	 
	System.out.println("Success of test cases and its details are : "+result.getName());  
	}  
	  
	//@Override  
	public void onTestFailure(ITestResult result) {  
	  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	//@Override  
	public void onTestSkipped(ITestResult result) {  
	 
	System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  
	  
	//@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	 
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	//@Override  
	public void onStart(ITestContext context) {  
	 System.out.println("TestListener.onStart()");
	}  
	//@Override  
	public void onFinish(ITestContext context) {  
	 System.out.println("TestListener.onFinish()");
	}  
	}  
	  
