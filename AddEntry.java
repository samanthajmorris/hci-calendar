import java.io.FileReader;
import java.util.Iterator;
import java.io.FileWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
public class AddEntry {
 
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
 
        try {
            //Read from the file
            Object obj = parser.parse(new FileReader("/Users/samanthamorris/Documents/hci-calendar-master/sample.json"));
            
            //Create the JSONObject version of the file
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);
            
            //Add new entry to the JSONObject
            jsonObject.put("New Person", "10110");
            System.out.println('\n');
            System.out.println(jsonObject);
            
            //Write the new JSONObject to the file
            try (FileWriter file = new FileWriter("/Users/samanthamorris/Documents/hci-calendar-master/sample.json")) 
            {
              file.write(jsonObject.toString());
              System.out.println("Successfully Copied JSON Object to File.");
              //System.out.println("\nJSON Object: " + obj); 
            } 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}