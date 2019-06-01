package SignInInfo;

import java.io.File;
import org.openqa.selenium.By;


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
