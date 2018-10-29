import java.io.FileWriter;
import java.io.IOException;
//import org.json.JSONObject;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 


public class SamsFunctions {
  
  public SamsFunctions() {
    //contstructor
  }
  
  public static void addEntry(String name, String num, String pathToFile){
    
    Path path = Paths.get(pathToFile);

    if (Files.exists(path)) {
      // file exist
      JSONParser parser = new JSONParser();
 
        try 
        {
            //Read from the file. Take path as a variable.
            Object obj = parser.parse(new FileReader(pathToFile));
            
            //Create the JSONObject version of the file
            JSONObject jsonObject = (JSONObject) obj;
            
            //Add new entry to the JSONObject
            jsonObject.put(name, num);
            
            //Write the new JSONObject to the file
            try (FileWriter file = new FileWriter(pathToFile)) 
            {
              file.write(jsonObject.toString());
              System.out.println("Successfully Copied JSON Object to File.");
            } 
        }
        catch (Exception e) 
        {
          System.out.println("ERROR: addEntry");
          e.printStackTrace();
        }     
    }

    if (Files.notExists(path)) {
      // file is not exist
      //Creates a JSON Object containing all the information. This is what will be created when a person adds their availability. Could be with variabiles object.put(name, number)
      JSONObject obj = new JSONObject();
      obj.put(name, num);
 
      //Write the JSON Object to a JSON file, and if the file does not exist, create it.
      try (FileWriter file = new FileWriter(pathToFile)) 
      {
        file.write(obj.toString());
        System.out.println("Successfully Copied JSON Object to File...");
        //System.out.println("\nJSON Object: " + obj); 
      }
      catch (Exception e) 
        {
            e.printStackTrace();
        }   
 
    }
    
  }
  
  public static String calculate(String pathToFile){
    try
    {
      //Read in the contents from the file
      String contents = new String(Files.readAllBytes(Paths.get(pathToFile))); 
      
      //Convert the file to a Hashmap in order to do things
      Gson gson = new Gson();
      Type type = new TypeToken<HashMap<String, String>>(){}.getType();
      HashMap<String, String> myMap = gson.fromJson(contents, type);
      //System.out.println("Here are your entries: ");
      //System.out.println(myMap);
      
      //Instantiate array of all 1's. Change 5 to 252.
      int[] availability = new int[252];
      for (int i = 0; i < availability.length; i++)
      {
        availability[i] = 1;
      }
      
      //For each digit associated with each name, iterate through the number. If the digit is a 0, change the availability array 
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
      //System.out.println("Availability: ");
      String result = "";
      for (int i = 0; i < availability.length; i++)
        { 
          result = result + availability[i];
          //System.out.print(availability[i]);
        }
      return result;
    }
    catch (IOException e) {
            e.printStackTrace();
            return null;
  }
    
    
  }
  
  /*public static void main(String[] args) throws IOException {
    String pathy = "/Users/samanthamorris/Documents/hci-calendar-master/sample.json";
    
    addEntry("Samantha", "10110", pathy);
    addEntry("Aisha", "11100", pathy);
    addEntry("Keara", "10000", pathy);
    System.out.println("Availability: ");
    System.out.println(calculate(pathy));
  }*/
    
  
}


