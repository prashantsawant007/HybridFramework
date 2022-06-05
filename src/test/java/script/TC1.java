package script;

import org.testng.annotations.Test;

import com.excelread.xls_Reader;

import Config.StartBrowser;
import Reuse.CommoFunction;

public class TC1 extends StartBrowser {
  @Test
  public void login_logout() throws Exception {
	  CommoFunction cfs=new CommoFunction();
	  xls_Reader reader= new xls_Reader();
	  String un=reader.getCellData1("Sheet1","Name");
	  String pw=reader.getCellData("Sheet1","password");
	  cfs.login(un, pw);
	  cfs.logout();
	  
  }
}
