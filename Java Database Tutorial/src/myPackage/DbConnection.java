package myPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fares Abu Ali
 */
public class DbConnection {
    
    public static Connection connect(){
        
        Connection con = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            // connecting to our database
            //con = DriverManager.getConnection("jdbc:sqlite:javaDatabaseTutorial.db");
           con = DriverManager.getConnection("jdbc:sqlite:Employees.db"); 

            
            System.out.println("Connected!");
        } 
        catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex+"");
//            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }// end method connect
    

    
    
}// end class
