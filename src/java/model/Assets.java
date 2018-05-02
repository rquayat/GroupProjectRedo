
package model;

public class Assets {
    private int assetid;
    private String category;
    private String name;
    private String value;
    private String dateofpurchase;
    
 
     public Assets() {
        this.assetid = 0;
        this.category = "";
        this.name = "";
        this.value = "";
        this.dateofpurchase = "";
       
        
    
     }
    public Assets( int assetid, String category, String name, String value, String dateofpurchase) {
        this.assetid = assetid;
        this.category = category;
        this.name = name;
        this.value = value;
        this.dateofpurchase = dateofpurchase;
        
        
        
    }

    public int getAssetId() {
        return assetid;
    }

    public void setAssetId(int assetid) {
        this.assetid = assetid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDateOfPurchase() {
        return dateofpurchase;
    }

    public void setDateOfPurchase(String dateofpurchase) {
        this.dateofpurchase = dateofpurchase;
    }

    @Override
    public String toString() {
        return "Assets{" + "assetid=" + assetid + ", category=" + category + ", name=" + name + ", value=" + value + ", dateofpurchase=" + dateofpurchase + '}';
    }

    

  
    
    
}
