package WebdriverCommands;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;

import Config.StartBrowser;

public class ActionDriver {
WebDriver driver;
public ActionDriver(){
	driver = StartBrowser.driver;
}
public void navigateToApplication(String url) throws Exception {
	try {
		driver.get(url);
		StartBrowser.childTest.pass("Sucessfullly navigated to URL :"+url);
	}catch(Exception e) {
		StartBrowser.childTest.fail("Unable To navigated to URL :"+url);
    throw e;
		
	}
}
public void click(By locator, String eleName) throws Exception {
	try {
		driver.findElement(locator).click();
		StartBrowser.childTest.pass("Sucessfullly click on :"+eleName);

	}catch(Exception e) {
		StartBrowser.childTest.fail("Unable to click on :"+eleName,
				MediaEntityBuilder.createScreenCaptureFromBase64String
				(screenShot()).build());
		StartBrowser.childTest.info(e);
		throw e;
	}
}
public void type(By locator,String testData,String eleName) throws Exception{
	try {
	driver.findElement(locator).sendKeys(testData);
    StartBrowser.childTest.pass("performance type in :"+eleName+"with data:"+testData);
	}catch(Exception e) {
    StartBrowser.childTest.fail("unable to perform type action in :"+eleName+"with data"+testData,
	MediaEntityBuilder.createScreenCaptureFromBase64String
	(screenShot()).build());
	StartBrowser.childTest.info(e);
	throw e;
	}
}
public String getText(By locator) {
	try {
		String x=driver.findElement(locator).getText();
		StartBrowser.childTest.pass("Text is :"+x);
		return x;
	}catch(Exception e) {
		StartBrowser.childTest.fail("unable to return text");
		return null;
	}
}
public void mouseHover(By locator, String eleName) throws Exception {
	try {
	Actions a= new Actions(driver);
	WebElement mo=driver.findElement(locator);
	a.moveToElement(mo).build().perform();
	StartBrowser.childTest.pass("performed mousehour on :"+eleName);
} catch(Exception e) {
	StartBrowser.childTest.fail("unable to perform mousehour on :"+eleName,
			MediaEntityBuilder.createScreenCaptureFromBase64String
			(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
}



} public void SelectByVisibleText(By locator,String visibleText) throws Exception {
	try {
	WebElement dd=driver.findElement(locator);
	Select s=new Select(dd);
	s.selectByVisibleText(visibleText);
	StartBrowser.childTest.pass("Selected" +visibleText+ "value from dropdown");
	}catch(Exception e) {
		StartBrowser.childTest.fail("Unable to Selecte" +visibleText+ "value from dropdown",
				MediaEntityBuilder.createScreenCaptureFromBase64String
				(screenShot()).build());
				StartBrowser.childTest.info(e);
				throw e;
	}		

	}
public void SelectByIndex(By locator,String index) throws Exception {
	try {
	WebElement dd=driver.findElement(locator);
	Select s=new Select(dd);
	s.selectByVisibleText( index);
	StartBrowser.childTest.pass("Selected" + index+ "value from dropdown");
	}catch(Exception e) {
		StartBrowser.childTest.fail("Unable to Selecte" + index+ "value from dropdown",
				MediaEntityBuilder.createScreenCaptureFromBase64String
				(screenShot()).build());
				StartBrowser.childTest.info(e);
				throw e;
	}		
}
public String getParentwindow() {
	return driver.getWindowHandle();
	}

public void switchtoChildWindow(By locator,String expText) {
	Set<String> window=driver.getWindowHandles();
	try {
		for (String string:window) {
			driver.switchTo().window(string);
			if(getText(locator).equals(expText)) {
				System.out.println("I am in correct window");
				break;
			}
			else {
				System.out.println("I am in wrong window");
			}
			}
		
	}catch(Exception e) {
		
	}
	

	
}

private String screenShot() {
	// TODO Auto-generated method stub
	return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
}

public void mouseHoverAndClickSubMenu(By menuLocator,By subMenuLocator, String menu, String subMenu) throws Exception {
	try {
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(menuLocator);
		act.moveToElement(ele).build().perform();
		Thread.sleep(3000);
		driver.findElement(subMenuLocator).click();
		StartBrowser.childTest.pass("Sucesssfullly mouse hover on menu: "+menu+"and clicked on submenu:"+subMenu);
	}catch(Exception e) {
		StartBrowser.childTest.fail("Sucesssfullly mouse hover on menu: "+menu+"and clicked on submenu:"+subMenu,
		MediaEntityBuilder.createScreenCaptureFromBase64String
		(screenShot()).build());
		StartBrowser.childTest.info(e);
		throw e;
	}
	}
public boolean isElePresent(By locator,String elementName) {
	try {
		driver.findElement(locator);
		StartBrowser.childTest.pass("Element : "+elementName +" is present");
		return true;
	}catch(Exception e) {
		System.out.println("Element is not present");
		StartBrowser.childTest.pass("Element : "+elementName +" is not present",
		MediaEntityBuilder.createScreenCaptureFromBase64String
		(screenShot()).build());
		return false;
	}
	

	
}
}
   

