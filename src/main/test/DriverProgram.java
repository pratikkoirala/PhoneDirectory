package main.test;

import main.java.*;
import java.io.IOException;

public class DriverProgram {

	public static void main(String[] args) throws IOException{
		
			PhoneDirectory testDirectory = new PhoneDirectory();
			
			testDirectory.addEntry("John", "123456");
			
			testDirectory.deleteEntry("Bobby");	
			
			String getNumberOutput = testDirectory.getNumber("Joanna");
			System.out.println("Joanna's number is:" + getNumberOutput);
			
			testDirectory.changeEntry("Don", "111111");
			
	}

}
