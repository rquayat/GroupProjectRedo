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
import model.Users;


/**
 *
 * @author colbert
 */
public class Admin_UsrMgr_AddUserQuery {
  
    private Connection conn;
    
    public Admin_UsrMgr_AddUserQuery() throws ClassNotFoundException, SQLException {

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
            
            conn = DriverManager.getConnection(url, username, passwd);
            
        } catch (IOException ex) {
            Logger.getLogger(Admin_UsrMgr_AddUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    public void doAdd(Users user){
       
        try {
            String query1="INSERT INTO bookmarks_siteusers (email, passwd, firstname, lastname) VALUES (?, ?, ?, ?)";
            
            PreparedStatement ps1 = conn.prepareStatement(query1);
            
            ps1.setString(1, user.getEmail());
            ps1.setString(2, user.getPasswd());
            ps1.setString(3, user.getFirstName());
            ps1.setString(4, user.getLastName());
            
            ps1.executeUpdate();
            
            
            String query2="INSERT INTO bookmarks_usersinroles (email, rolename) VALUES (?, ?)";
            
            PreparedStatement ps2 = conn.prepareStatement(query2);
            
            ps2.setString(1, user.getEmail());
            ps2.setString(2, user.getRole());
            
            ps2.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin_UsrMgr_AddUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
