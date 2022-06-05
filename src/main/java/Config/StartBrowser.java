package Config;



import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class StartBrowser {
	public static WebDriver driver;
	ExtentSparkReporter htmlReporter; 
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	/*@Test
	public void launch() {
		driver.get("https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager/5.1.1");
	}*/
	@BeforeTest
	public void report() {
		htmlReporter=new ExtentSparkReporter("Report/report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}
	@BeforeMethod
	public void method(Method method) {
		parentTest = extent.createTest(method.getName());
	}
	@BeforeClass
public void beforeClass() {
		
	driver = new ChromeDriver();
	driver.manage().window().maximize();
}
	@AfterClass
	public void afterClass() {
	driver.quit();
	extent.flush();
}
}
//StartBrowser----ActionDriver---LoginPage--commonFunction--TC1
