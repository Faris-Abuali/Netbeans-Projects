
package javadbwithoracle;

import java.sql.*;

/**
 *
 * @author Fares Abu Ali
 */
public class DbConnection {
    
    public static void main(String[] args) {
        
         
        ResultSet rs = null;
        Connection con = null;
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Connection con = DriverManager.getConnection("url","username","password")

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
            
            Statement st = con.createStatement();
            
            String sql = "select * from countries";
            
             rs = st.executeQuery(sql);
            
            while(rs.next()){
                System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3));
                
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
            
        }
           finally{
           
           try{
               con.close();
               rs.close();
           }
           catch(SQLException e){
               System.out.println(e.toString());
           }
       }
    }// end main
}// end class
