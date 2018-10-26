
 
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;
 
 
public class CreateFile {
 
 public static void main(String[] args) throws IOException {
 
  //Creates a JSON Object containing all the information. This is what will be created when a person adds their availability. Could be with variabiles object.put(name, number)
  JSONObject obj = new JSONObject();
  obj.put("Samantha", "10110");
  obj.put("Aisha", "00110");
  obj.put("Vistassja", "00000");
 
  //Write the JSON Object to a JSON file, and if the file does not exist, create it.
  try (FileWriter file = new FileWriter("/Users/samanthamorris/Documents/hci-calendar-master/sample.json")) 
  {
   file.write(obj.toString());
   System.out.println("Successfully Copied JSON Object to File...");
   System.out.println("\nJSON Object: " + obj); 
  }          
 
 }
}
