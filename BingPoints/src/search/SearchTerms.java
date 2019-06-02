package search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;


public class SearchTerms {
	
	private String[] searchTerms;
	
	
	public String[] getSearchTerms() throws IOException {
		setSearchTerms();
		Scanner read = new Scanner(new File("C:\\Users\\colli\\eclipse-workspace\\SignInInfo\\Resources\\modifiedlist.csv"));
		read.useDelimiter(",");
		
		int x = 0;
		while(read.hasNext()) {
			searchTerms[x] = (read.next());
			x++;
		}
		return searchTerms;
	}
	public void setSearchTerms() throws IOException {
		File file = new File("C:\\Users\\colli\\eclipse-workspace\\SignInInfo\\Resources\\Searches.txt");
		String str = FileUtils.readFileToString(file);
		
		//remove all numbers and replace ) with comma to make csv
		str.replace(')', ',');
		str.replace(".", "");
		str.replace("1","");
		str.replace("2","");
		str.replace("3","");
		str.replace("4","");
		str.replace("5","");
		str.replace("6","");
		str.replace("7","");
		str.replace("8","");
		str.replace("9","");
		str.replace("0","");

		FileWriter list = new FileWriter("");
		for(char a : str.toCharArray()) {
			list.append(a);
		}
		list.close();
		
	}
	
	
	
}
