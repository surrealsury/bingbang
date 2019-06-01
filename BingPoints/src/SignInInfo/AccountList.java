package SignInInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountList {
	
	private File list;
	private Scanner scan;
	private ArrayList<String> username;
	private ArrayList<String> password;
	
	
	public AccountList(File n) throws FileNotFoundException {
		this.list = n;
		scan = new Scanner(list);
		while(scan.hasNext()) {
			username.add(setNextUserName());
			password.add(setNextPassword());
		}
	}
	
	private String setNextUserName() {
		return scan.next();
	}
	private String setNextPassword() {
		return scan.next();
	}
	
	public ArrayList<String> getUserName() {
		return username;
	}
	
	public ArrayList<String> getPassword(){
		return password;
	}
	
	
	
	
}
