/*
 * File Name:	SamsFunctions.java
 * Author:		Samantha Morris
 * Purpose:		Adds user entries to
 * 				a) a new file, ScheduleMe.json (if none provided), located in
 * 					the user's Download directory
 * 				b) the file provided (at its original location)
 * 				
 * 				Compares and calculates the results of each entry (user) and
 * 				determines common availability.
 * 
 * Date:		October 27, 2018
 */

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class SamsFunctions {

	public String name;
	public String num;
	public String pathToFile;

	public SamsFunctions(String na, String n, String p) {
		//constructor
		String name = na;
		String num = n;
		String pathToFile = p;
	}

	public static void addEntry(String name, String num, String pathToFile) {
		if (pathToFile == null) {
			String home = System.getProperty("user.home");
			
			/* Change the next line if you wish
			 * to hard code your own path variable */
			pathToFile = home + "/Downloads/ScheduleMe.json";
		}

		Path path = Paths.get(pathToFile);

		if (Files.exists(path)) {
			// file exist
			JSONParser parser = new JSONParser();

			try 
			{
				try
				{
					// Read from the file. Take path as a variable.
					Object obj = parser.parse(new FileReader(pathToFile));

					// Create the JSONObject version of the file
					JSONObject jsonObject = (JSONObject) obj;
					System.out.println("before: " + jsonObject.toString());
					
					jsonObject.put(name, num);
					System.out.println("after:"+jsonObject.toString());
					// Write the new JSONObject to the file
					try (FileWriter file = new FileWriter(pathToFile)) 
					{
						file.write(jsonObject.toString());
						System.out.println("Successfully Copied JSON Object to File.");
					} 
				}

				catch (Exception e)
				{
					JSONObject obj = new JSONObject();
					obj.put(name, num);

					//Write the new JSONObject to the file
					try (FileWriter file = new FileWriter(pathToFile)) 
					{
						file.write(obj.toString());
						System.out.println("Successfully Copied JSON Object to File.");
					} 
				}
			}
			catch (Exception e) 
			{
				System.out.println("ERROR: addEntry");
				e.printStackTrace();
			}     
		}

		if (Files.notExists(path)) {
			// file does not exist
			// Creates a JSON Object containing all the information. This is what will be created when a person adds their availability. Could be with variables object.put(name, number)
			JSONObject obj = new JSONObject();
			obj.put(name, num);

			// Write the JSON Object to a JSON file, and create file.
			try (FileWriter file = new FileWriter(pathToFile)) 
			{
				file.write(obj.toString());
				System.out.println("Successfully Created and Copied JSON Object to File...");
			}
			catch (Exception e) 
			{
				System.out.println("File not exist error");
				e.printStackTrace();
			}   

		}

	}

	public static String calculate(String pathToFile){
		try
		{
			// Read in the contents from the file
			String contents = new String(Files.readAllBytes(Paths.get(pathToFile))); 

			// Convert the file to a Hashmap in order to do things
			Gson gson = new Gson();
			Type type = new TypeToken<HashMap<String, String>>(){}.getType();
			HashMap<String, String> myMap = gson.fromJson(contents, type);
			
			// Instantiate array of all 1's. Change 5 to 252.
			int[] availability = new int[252];
			for (int i = 0; i < availability.length; i++)
			{
				availability[i] = 1;
			}

			// For each digit associated with each name, iterate through the number.
			// If the digit is a 0, change the availability array.
			for (Object value : myMap.values()) 
			{
				String number = value.toString();
				for (int i = 0; i < number.length(); i++)
				{
					if (number.charAt(i) == '0')
					{
						availability[i] = 0;
					}
				}

			}

			String result = "";
			for (int i = 0; i < availability.length; i++)
			{ 
				result = result + availability[i];
			}
			return result;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}


	// Runs some sample input.
	// For debugging purposes only.
//	public static void main(String[] args) throws IOException {
//		String pathy = "/Users/keara/workspace/sample.json";
//
//		addEntry("Samantha", "10110", pathy);
//		System.out.println(calculate(pathy));
//		addEntry("Aisha", "11000", pathy);
//		System.out.println(calculate(pathy));
//		addEntry("Keara", "00001", pathy);
//		System.out.println("Availability: ");
//		System.out.println(calculate(pathy));
//	}
	
}


