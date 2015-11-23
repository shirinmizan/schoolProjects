/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.sql.*;

/**
 *
 * @author Shirin Mizan
 */
public class connectionControl {
    
    public connectionControl(){}
    
    public Connection connect() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        Connection con = null; 
        try{
            // define all connection data 
        String driverName="com.mysql.jdbc.Driver"; 
        String dbUrl="jdbc:mysql://localhost:3306/store"; 
        String userName="root"; 
        String passWord="sesame"; 
        // open the connection
         Class.forName(driverName).newInstance();
         con = DriverManager.getConnection(dbUrl, userName, passWord);
         return con;
        
        }catch(SQLException e){
            return null;
        
        }
   
    }
    
    public void freeConnection(Connection c) throws SQLException{
        if(c!=null)
            c.close(); 
    }
    
    
}
    

