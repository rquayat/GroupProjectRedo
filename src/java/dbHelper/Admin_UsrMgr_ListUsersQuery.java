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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Users;


/**
 *
 * @author colbert
 */
public class Admin_UsrMgr_ListUsersQuery {
    private Connection conn;
    private ResultSet results;
    
    public Admin_UsrMgr_ListUsersQuery() {

        try {
            Properties props = new Properties(); //MWC
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            props.load(instr);
            instr.close();
            
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, passwd);
        
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Admin_UsrMgr_ListUsersQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    public void doRead(){
        
        try {
            String query = "SELECT * FROM bookmarks_siteusers INNER JOIN bookmarks_usersinroles ON bookmarks_siteusers.email = bookmarks_usersinroles.email";
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Admin_UsrMgr_ListUsersQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<Users> listAllUsers() throws SQLException {
       
        //Create a new Java list, populated with Tasks(model) with the reference variable allTasks
        List<Users> allUsers = new ArrayList<>();

            while(this.results.next()){  //iterate through the results
                
                //populate a new instance of the model
                Users user = new Users();
                user.setFirstName(this.results.getString("firstname"));
                user.setLastName(this.results.getString("lastname"));
                user.setEmail(this.results.getString("email"));
                user.setPasswd(this.results.getString("passwd"));
                user.setRole(this.results.getString("rolename"));
                
                
                //add that instance to the list named allTasks
                allUsers.add(user);
            }

        //when done, return the List allTasks to the servlet
        return allUsers;
    }
    
    
}
