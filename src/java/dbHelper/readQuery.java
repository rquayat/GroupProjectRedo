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
import model.Assets;




public class readQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public readQuery() {
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // SOLID CONNECTION TO DATABASE SHOULD BE ESTABLISHED AFTER ABOVE IS RUN!
    
    
    public void doRead() {
        try {
            String query ="SELECT * FROM assets";
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLTable() {
        String table = "";
            table += "<table>";
        
        
        try {
           
            
            while (this.results.next()) {
                Assets asset = new Assets();
                asset.setAssetId(this.results.getInt("assetid"));
                asset.setCategory(this.results.getString("category"));
                asset.setName(this.results.getString("name"));
                asset.setValue(this.results.getString("value"));
                asset.setDateOfPurchase(this.results.getString("dateofpurchase"));
                
                
                table += "<tr>";
                
                    table += "<td>";
                        table += asset.getAssetId();
                    table += "</td>";
                
                    table += "<td>";
                        table += asset.getCategory();
                    table += "</td>";
               
                    table += "<td>";
                        table += asset.getName();
                    table += "</td>";
                
                    table += "<td>";
                        table += asset.getValue();
                    table += "</td>";
                
                    table += "<td>";
                        table += asset.getDateOfPurchase();
                    table += "</td>";
      
                    table += "<td>";
                        table += "<a href=update?assetid=" + asset.getAssetId() + "> Update </a>" + "<a href=delete?assetid=" + asset.getAssetId() + "> Delete <a/>";
                    table += "</td>";
                    
                table += "</tr>";
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(readQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        table += "</table>";
            return table;
     
    }


   
    
}

