package ObjectRepository;

import org.openqa.selenium.By;

public class LoginPage {
public static By txtuserName = By.name("userName");
public static By txtPassword=By.xpath("//input[@name='password']");//By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input\r\n");
public static By btnSignIn=By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input");
}
