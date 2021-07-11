
package filesdecember;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Fares Abu Ali
 */
public class FilesDecember {

    
    public void find(File f,String key) throws IOException{
        
        if(f.isDirectory()){
            String[] list = f.list();
        }
        

        
        
    }
    
    
    public static void main(String[] args) throws IOException {
       
        
        
        File f = new File("Fat.txt");
        
            
        FileOutputStream fileO = null;
        
        
        fileO = new FileOutputStream(f,true);
        fileO.write("hahahdddd".getBytes());
        
        System.out.println("HAH");
        fileO.close();


    FileInputStream inputStream = new FileInputStream(f);   
        
        
        
        
//        File f =new File(pathname);
//        
//        FileInputStream inputStream = new FileInputStream(f);
        
        
    }
    
    
    
    
    
//    public static void echo(InputStream in)throws IOException{
//        
//        while(true){
//            
//            
//            
//            int i =in.read();
//            
//            if(i==45)
//        }
//    }
    
}
