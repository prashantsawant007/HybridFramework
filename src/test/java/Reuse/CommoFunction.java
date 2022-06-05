package Reuse;

import org.openqa.selenium.WebDriver;

import Config.StartBrowser;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import WebdriverCommands.ActionDriver;

public class CommoFunction {
WebDriver driver;
ActionDriver aDriver;
public CommoFunction() {
	driver=StartBrowser.driver;
	aDriver = new ActionDriver();
}
public void login(String username,String password) throws Exception {
	StartBrowser.childTest=StartBrowser.parentTest.createNode("Login to application");
aDriver.navigateToApplication("https://demo.guru99.com/test/newtours/index.php");
aDriver.type(LoginPage.txtuserName,"userName","Username text box");
aDriver.type(LoginPage.txtPassword,"password","Password field");
aDriver.click(LoginPage.btnSignIn,"SignIn button");

}
public void logout() throws Exception {
	StartBrowser.childTest=StartBrowser.parentTest.createNode("Logout to application");
aDriver.click(HomePage.linkSignOut,"Signout link");
}
}
