
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

/**
 *
 * @author rquayat
 */
public class readRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Assets asset = new Assets();
    private int assetid;
    
    public readRecord (int AssetId) throws ClassNotFoundException, SQLException {

        try {
            Properties props = new Properties();
            InputStream instr = getClass().getResourceAsStream("dbConn.properties");
            props.load(instr);
            instr.close();
            
            String driver = props.getProperty("driver.name");
            String url = props.getProperty("server.name");
            String username = props.getProperty("user.name");
            String passwd = props.getProperty("user.password");
            
            this.assetid = AssetId;
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (IOException ex) {
            Logger.getLogger(readRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
}
    
    public void doRead() {
    
        
        try {
            //set up a string to hold our query
            String query = "SELECT * FROM Assets WHERE assetid=?";
            
            //create a prepared statement using our query string
            PreparedStatement ps = conn.prepareStatement(query);
            
            //fill in the prepared statement
            ps.setInt(1, assetid);
            
            //execute the query
            this.results = ps.executeQuery();
            
            this.results.next();
            
            asset.setAssetId(this.results.getInt("assetid"));
            asset.setCategory(this.results.getString("category"));
            asset.setName(this.results.getString("name"));
            asset.setValue(this.results.getString("value"));
            asset.setDateOfPurchase(this.results.getString("dateofpurchase"));
            
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(readRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public Assets getAsset() {
        return this.asset;
    }
}
