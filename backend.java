
public class backend
{
  public String returnString; 
  public backend(boolean [][] array, String name, String path)
  {
    
    convert newCon = new convert();
    returnString = newCon.convertArray(array);
    System.out.println(returnString);
    
    SamsFunctions func = new SamsFunctions();
    func.addEntry(name, returnString, path);
     
  }

  
  public static void main(String[] args){
    boolean[][] test = new boolean[7][36];
    for(int i = 0; i<7; i++)
      for(int j = 0; j<36;j++)
      test[i][j] = true;
    
    boolean[][] test2 = new boolean[7][36];
    for(int i = 0; i<7; i++)
      for(int j = 0; j<36;j++)
      test2[i][j] = false;
    
    backend sample = new backend(test, "Samantha", "/Users/samanthamorris/Documents/hci-calendar-master/sample.json");
    backend sample2 = new backend(test2, "Aisha", "/Users/samanthamorris/Documents/hci-calendar-master/sample.json");
    
    SamsFunctions function = new SamsFunctions();
    System.out.println("\nAvailability: ");
    System.out.println(function.calculate("/Users/samanthamorris/Documents/hci-calendar-master/sample.json"));
  }
}
  

