package main.java;

import java.io.*;
import java.util.Properties;


public class PhoneDirectory {
	private Properties prop = new Properties();
	private String file_location;
	
	public PhoneDirectory() throws IOException
	{		
		InputStream input = new FileInputStream("src/main/resources/phone.properties");
		prop.load(input);
		file_location = prop.getProperty("location");
	}
	

	public void addEntry(String name, String number) throws IOException
	{
		OutputStream output = new FileOutputStream(file_location, true); 
		prop.setProperty(name, number);
		prop.store(output, null);
		output.close();	
	}
	
	
	public void deleteEntry(String name) throws IOException
	{	
		Properties prop = new Properties();
		InputStream input = new FileInputStream(file_location);
		prop.load(input);
		prop.remove(name);
		input.close();
		OutputStream output = new FileOutputStream(file_location); 
		prop.store(output, null);
		output.close();		
	}
	

	public String getNumber(String name) throws IOException
	{		
		InputStream input = new FileInputStream(file_location);
		prop.load(input);
		String phone_number = prop.getProperty(name);
		input.close();
		return phone_number;	
	}
	
	public void changeEntry(String name, String number) throws IOException
	{	
		InputStream input = new FileInputStream(file_location);
		prop.load(input);
		prop.replace(name, number);
		input.close();
		OutputStream output = new FileOutputStream(file_location); 
		prop.store(output, null);
		output.close();		
	}
}

