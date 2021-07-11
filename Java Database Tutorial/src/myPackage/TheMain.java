package myPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fares Abu Ali
 */
public class TheMain {

    public static void main(String[] args) {

        //DbConnection.connect();
        //insert("Fares", "Abuali", "f.h.abuali@students.ptuk.edu.ps", "0000");
        // insert("Benson", "Karue", "benson@test.com", "myPassword");
        
//        //insert(41, 201810408, "Fares");
//        insert(51, 201810409, "Waleed");
//        insert(61, 202010423, "Bashar");
//        insert(71, 201910303, "Huthaifa");
//        insert(81, 201710408, "Abood");
//        insert(91, 201710408, "Nassir");
//        insert(11, 201610408, "Ahmad");
//        insert(21, 201510408, "Yahya");
//        insert(31, 201410408, "Ezzat");

 //       insert(111, 201410408, null);
        
        
          // readAllData();
            //readSpecificRow(202010423);
            
            //updateFirstNameFor(81, "Abdullah");
            
            
            //deleteRow(20181838);
            
           // count("*");
            count("name");
    }

    private static void insert(int id, int stu_id, String name) {
        
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        
        try {
            String sql = "INSERT INTO emp(id, stu_id, name) VALUES(?,?,?) ";
            ps = con.prepareStatement(sql);   
            // So, I think that "prepareStatement" method is a method in class Connection
            // that returns an object of type PreparedStatement
            
            ps.setInt(1, id);
            ps.setInt(2, stu_id);
            ps.setString(3, name);
            ps.execute();
            
            System.out.println("Data has been inserted!");
        }
        catch (SQLException e) {
            System.out.println(e.toString());
            // always remember to close database connections
        }
        finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }

        }
    }// end method connect
    
//================================================================================    
    private static void readAllData(){
        
       Connection con = DbConnection.connect();
       PreparedStatement ps = null;
       
       ResultSet rs = null;
       
       try{
           
           String sql = "SELECT * FROM emp";
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           System.out.println("ALL EMPLOYEES\n");
           
           while(rs.next()){
               
               int id = rs.getInt("id");
               int stu_id = rs.getInt("stu_id");
               String name = rs.getString("name");
               
               System.out.println("id: "+id+", stu_id: "+stu_id+", name: "+name+"\n"
                       + "====================");
           }
       }
       catch(SQLException e){
           System.out.println(e.toString());
       }
       finally{
           
           try{
               ps.close();
               con.close();
               rs.close();
           }
           catch(SQLException e){
               System.out.println(e.toString());
           }
       }
          
    }// end method readAllData
//================================================================================
    
    private static void readSpecificRow(int entered_stu_id){
        
       
       Connection con = DbConnection.connect();
       PreparedStatement ps = null;
       
       ResultSet rs = null;
       
       try{
           
           String sql = "SELECT * FROM emp where stu_id = ? ";
           ps = con.prepareStatement(sql);
           //*** now we wnat to replace the ? by the entered_stu_id 
           ps.setInt(1, entered_stu_id);
            
           rs = ps.executeQuery();
           
           // we are reading one row, so no need to loop 
          
           
           while(rs.next()){

// This is possible:
//               int id = rs.getInt("id");
//               int stu_id = rs.getInt("stu_id");
//               String name = rs.getString("name");

// or also we can say:
               int id = rs.getInt(1);
               int stu_id = rs.getInt(2);
               String name = rs.getString(3);
// because 1 is the first column of the result set, 2 is the second column, ans so on...
               
               System.out.println("id: "+id+", stu_id: "+stu_id+", name: "+name+"\n"
                       + "====================");
           }
       }
       catch(SQLException e){
           System.out.println(e.toString());
       }
       finally{
           
           try{
               ps.close();
               con.close();
               rs.close();
           }
           catch(SQLException e){
               System.out.println(e.toString());
           }
       }
       
       
    }// end method
//================================================================================

    private static void updateFirstNameFor(int entered_id, String newName){
        
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        
        try{
            String sql = "UPDATE emp SET name = ? WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, newName);
            ps.setInt(2, entered_id);

            ps.execute();
            System.out.println("Data has been updated!");
        }
        catch(SQLException e){
           System.out.println(e.toString());
       }
        finally{
            
            try{
               ps.close();
               con.close();
           }
           catch(SQLException e){
               System.out.println(e.toString());
           }
        }
        
               
    }// end method
//================================================================================    

    private static void deleteRow(int entered_stu_id){
        
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        
        
         try{
            String sql = "DELETE FROM emp WHERE stu_id = ? ";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, entered_stu_id);
            
            ps.execute();
            System.out.println("Data has been deleted!");
            
        }
        catch(SQLException e){
           System.out.println(e.toString());
       }
        finally{
            
            try{
               ps.close();
               con.close();
           }
           catch(SQLException e){
               e.printStackTrace();
           }
        }
        
    }// end method
    
//================================================================================    
private static void count(String fieldToBeCounted){
    
    Connection con = DbConnection.connect(); 
    PreparedStatement ps = null; 
    ResultSet rs = null;
    
      try{
            String sql = "SELECT COUNT(?) FROM emp";
            
            
            ps = con.prepareStatement(sql);
            ps.setString(1, fieldToBeCounted);
          

            rs = ps.executeQuery();
            
            // We can expect that the result set of this query was single row and column
            int size = rs.getInt(1);
            System.out.println("We have "+size+" employees");
            
        }
        catch(SQLException e){
           System.out.println(e.toString());
       }
        finally{
            
            try{
               ps.close();
               con.close();
               rs.close();
           }
           catch(SQLException e){
               e.printStackTrace();
           }
        }
      
}// end method
    
//================================================================================    

    
//================================================================================

}// end class
