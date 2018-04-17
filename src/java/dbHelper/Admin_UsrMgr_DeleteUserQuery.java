/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbHelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author colbert
 */
public class Admin_UsrMgr_DeleteUserQuery {
    
    private Connection conn;
    
    public Admin_UsrMgr_DeleteUserQuery() throws ClassNotFoundException, SQLException{
        
        try {
            Properties props = new Properties();
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            
            props.load(instr);
            instr.close();
            
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url,username,passwd);
            
        } catch (IOException ex) {
            Logger.getLogger(Admin_UsrMgr_DeleteUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void doDelete(String email)
    {
        
        try {
            //set up a string to hold query
            String query1 = "DELETE FROM bookmarks_usersinroles WHERE email = ?";
            
            //create a prepared statement using the query string
            PreparedStatement ps1 = conn.prepareStatement(query1);
            
            //fill in the preparedStatement
            ps1.setString(1, email);
            
            //execute the query
            ps1.executeUpdate();
            
            
            String query2 = "DELETE FROM bookmarks_siteusers WHERE email = ?";
            
            //create a prepared statement using the query string
            PreparedStatement ps2 = conn.prepareStatement(query2);
            
            //fill in the preparedStatement
            ps2.setString(1, email);
            
            //execute the query
            ps2.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin_UsrMgr_DeleteUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
