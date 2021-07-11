package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Fares Abu Ali
 */
public class ParseJSON {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
               
        JSONParser parser = new JSONParser();
        
        try{
            
            
            Object obj = parser.parse(new FileReader("newCreatedJSON.txt"));
            
            JSONObject jsonObject =  (JSONObject) obj;
            
            String name   = (String) jsonObject.get("name");
            
            Long age   = (Long) jsonObject.get("age");
            
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            
            
            Iterator<Object> iterator =  msg.iterator();
            
            ArrayList<String> msgArrList = new ArrayList();
            
            while(iterator.hasNext()){
                //System.out.println(iterator.next());
                msgArrList.add((String)iterator.next());
            }
            
            System.out.println("Name = " + name);
            System.out.println("Age = " + age);
            System.out.println("List of Messages = " + msgArrList);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        
        //========================= Now I have successfully parsed all the json file contents =====================
        
    }// end main
            
}// end class