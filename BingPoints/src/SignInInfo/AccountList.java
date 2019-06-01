package SignInInfo;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.*;

public class AccountList {
	
	private File list;
	
	
	public AccountList(File n) {
		this.list = n;
	}
	
	public String getNextUserName() {
		list.getNext();
	}
	public String getNextPassword() {
		list.getNext();
	}
	
	
	
}
