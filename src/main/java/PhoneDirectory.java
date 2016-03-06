package main.java;

import java.io.*;
import java.util.Properties;

/*Returns a PhoneDirectory object that has four methods  
 */
public class PhoneDirectory {
	private Properties prop = new Properties();
	private String file_location;
	
	
	/* Constructor of the PhoneDirectory class
	 */
	public PhoneDirectory() throws IOException
	{		
		InputStream input = new FileInputStream("src/main/resources/phone.properties");
		prop.load(input);
		file_location = prop.getProperty("location");
	}
	
    /* @throws IOException if an input or output exception occurred
     * @param name  the name to be added in the directory
     * @param number the number to be added for that entry
     */
	public void addEntry(String name, String number) throws IOException
	{
		OutputStream output = new FileOutputStream(file_location, true); 
		prop.setProperty(name, number);
		prop.store(output, null);
		output.close();	
	}
	
	 /* @throws IOException if an input or output exception occurred
     * @param name     the name to be deleted from the directory
     */
	public void deleteEntry(String name) throws IOException
	{	
		InputStream input = new FileInputStream(file_location);
		prop.load(input);
		prop.remove(name);
		input.close();
		OutputStream output = new FileOutputStream(file_location); 
		prop.store(output, null);
		output.close();		
	}
	
	 /* @throws IOException if an input or output exception occurred
     * @param name     the name whose number is queried from the directory
     */
	public String getNumber(String name) throws IOException
	{		
		InputStream input = new FileInputStream(file_location);
		prop.load(input);
		String phone_number = prop.getProperty(name);
		input.close();
		return phone_number;	
	}
	
	 /* @throws IOException if an input or output exception occurred
     * @param name     the name whose number needs to be changed from the directory
     * @param number   the new number
     */
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

