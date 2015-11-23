/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import business.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Shirin Mizan
 */
public class ItemDB {
    
    public static int insert(Item itm) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
       
        //local objects that will be used in the insertion process
        PreparedStatement pstm = null;
        Connection con = null; 
        connectionControl conMngr = null; 
        try{
            // A sql statement which inserts a row into the phonetable
            String pStmnt ="INSERT INTO items (itemCode, itemName, Price)VALUES(?, ?, ?);";
             // to make a connection
            conMngr = new connectionControl();
            con = conMngr.connect();
            
            // create a preparedstatement object that models the sql statement
            pstm = con.prepareStatement(pStmnt);
            // set the parameters of the sql statement.
            // in other words, replaces the three ? with values
            pstm.setInt(1, itm.getiCode());
            pstm.setString(2, itm.getiName());
            pstm.setDouble(3, itm.getPrice());
            
            // execute the ps 
            return pstm.executeUpdate();
        
        }catch(SQLException e){
            // to indicate that no rows affected
            return 0;
        }finally{
            DBUtil.closePreparedStatement(pstm);
            conMngr.freeConnection(con);
        }
   
    }
    public static ResultSet showAll() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        Statement stmnt; 
        Connection con; 
        connectionControl conMngr; 
        ResultSet res;
        try{
        String stm = "SELECT * FROM items;";
        conMngr = new connectionControl();
        con = conMngr.connect();
        stmnt = con.createStatement(); 
        res = stmnt.executeQuery(stm);
        return res;
        }
        catch(SQLException e){
        return null;
        }
       }
}
