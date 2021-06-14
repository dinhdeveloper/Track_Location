package tcd.project.myapplication.models;

import java.io.Serializable;

public class ProductModel implements Serializable {

    private String id;
    private String id_forkey;
    private String productName;
    private String price;

    public ProductModel(String productName, String price) {
        this.productName = productName;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_forkey() {
        return id_forkey;
    }

    public void setId_forkey(String id_forkey) {
        this.id_forkey = id_forkey;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

