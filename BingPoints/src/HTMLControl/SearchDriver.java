package HTMLControl;

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.*;
import SignInInfo.AccountList;
import search.SearchTerms;

import java.util.ArrayList;
import java.util.Random;

public class SearchDriver {

	private WebDriver driver;
	private Robot rob;
	private SearchTerms terms;
	Random rand = new Random();
	public static void main(String[] args) throws InterruptedException {
		try {
			new SearchDriver();
		} catch (FileNotFoundException e) {

		} catch (AWTException a) {

		}
	}

	public SearchDriver() throws FileNotFoundException, AWTException, InterruptedException {
		//init vars
		AccountList accounts = new AccountList("File Location");
		terms = new SearchTerms();
		driver = new InternetExplorerDriver();
		rob = new Robot();
		
		
		for (int x = 0; x < accounts.getUserName().size(); x++) {
			driver.get("https://www.bing.com");
			signIn(accounts.getUserName().get(x), accounts.getPassword().get(x));
			search();
			signOut();
		}
	}

	public void signIn(String username, String password) {
		WebElement signinB = driver.findElement(By.name("id_l"));
		signinB.click();
		WebElement userField = driver.findElement(By.name("i0116"));
		userField.sendKeys(username);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		WebElement passField = driver.findElement(By.name("i0118"));
		passField.sendKeys(password);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		return;
	}

	public void signOut() {
		driver.get("https://www.bing.com");
		WebElement signout = driver.findElement(By.name("id_d"));
		signout.click();
		return;
	}

	public void search() throws InterruptedException {
		for(int x = 0; x < 60; x++) {
			WebElement searchField = driver.findElement(By.name("sb_form_q"));
			try {
				searchField.sendKeys(terms.getSearchTerms()[rand.nextInt(terms.getSearchTerms().length)]);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			rob.keyPress(KeyEvent.VK_ENTER);
			rob.keyRelease(KeyEvent.VK_ENTER);
			wait(100);
		}
	}

}
