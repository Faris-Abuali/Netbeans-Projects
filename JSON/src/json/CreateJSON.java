package json;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Fares Abu Ali
 */
/*
    {
    "age":100,
    "name":"mkyong.com",
    "messages":["msg 1","msg 2","msg 3"]
    }
 */
public class CreateJSON {

    public static void main(String[] args) {

        JSONObject obj = new JSONObject();

        obj.put("name", "mkyong.com");
        obj.put("age", 100);

        JSONArray list = new JSONArray();

        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

        try (FileWriter file = new FileWriter("newCreatedJSON.txt")) {

            file.write(obj.toString());
            
            file.flush();
        }// end try
        catch(IOException e){
            e.printStackTrace();
        }

    }// end main

}// end class
