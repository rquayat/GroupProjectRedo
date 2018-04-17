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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Users;


public class Admin_UsrMgr_Update_GetUserQuery {
    private Connection conn;
    private ResultSet results;
    private Users selectedUser = new Users();
    private String email;
    
    public Admin_UsrMgr_Update_GetUserQuery(String email) {

        try {
            Properties props = new Properties(); //MWC
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            props.load(instr);
            instr.close();
            
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            
            this.email = email;
            
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, passwd);
        
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Admin_UsrMgr_Update_GetUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    public void doReadUser(){
       
        try {
            String query = "SELECT * FROM bookmarks_siteusers INNER JOIN bookmarks_usersinroles ON bookmarks_siteusers.email = bookmarks_usersinroles.email WHERE bookmarks_siteusers.email = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            //fill in the preparedStatement
            ps.setString(1, email);
            
            //execute the query
            this.results = ps.executeQuery();
            
            this.results.next();
            
            //populate a new instance of the model
            //Users selectedUser = new Users();
            selectedUser.setFirstName(this.results.getString("firstname"));
            selectedUser.setLastName(this.results.getString("lastname"));
            selectedUser.setEmail(this.results.getString("email"));
            selectedUser.setPasswd(this.results.getString("passwd"));
            selectedUser.setRole(this.results.getString("rolename"));
        } catch (SQLException ex) {
            Logger.getLogger(Admin_UsrMgr_Update_GetUserQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    public Users getUser(){
    
    return this.selectedUser;

    }

}
  
    

