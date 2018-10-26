import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;



public class JsonCalculate
{
  public static void main( String[] args )
  {
    try
    {
      //Read in the contents from the file
      String contents = new String(Files.readAllBytes(Paths.get("/Users/samanthamorris/Documents/hci-calendar-master/sample.json"))); 
      
      //Convert the file to a Hashmap in order to do things
      Gson gson = new Gson();
      Type type = new TypeToken<HashMap<String, String>>(){}.getType();
      HashMap<String, String> myMap = gson.fromJson(contents, type);
      System.out.println(myMap);
      
      //Instantiate array of all 1's
      int[] availability = new int[5];
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
      System.out.println("Availability: ");
      for (int i = 0; i < availability.length; i++)
        { 
          System.out.print(availability[i]);
        }
    }
    catch (IOException e) {
            e.printStackTrace();
  }
    
      
    }
}
