package com.addrbook.domain;

/**
 * Created by alexandr on 08.04.15.
 */
public class Product {
    private Integer id;
    private Integer sku;
    private String name;
    private Double price;
    private Double mrp;
    private String description;
    private String packing;
    private String image;
    private Integer category;
    private Integer stock;
    private String status;

    public Product(){}
    public Product(Product product){
        this.id = product.id;
        this.sku = product.sku;
        this.name = product.name;
        this.price = product.price;
        this.mrp = product.mrp;
        this.description = product.description;
        this.packing = product.packing;
        this.image = product.image;
        this.category = product.category;
        this.stock = product.stock;
        this.status = product.status;
    }

    public Integer getId(){
        return id;
    }
    public Integer getSku(){
        return sku;
    }
    public String getName(){
        return name;
    }
    public Double getPrice(){
        return price;
    }
    public Double getMrp(){
        return mrp;
    }
    public String getDescription(){
        return description;
    }
    public String getPacking(){
        return packing;
    }
    public String getImage(){
        return image;
    }
    public Integer getCategory(){
        return category;
    }
    public Integer getStock(){
        return stock;
    }
    public String getStatus(){
        return status;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setSku(Integer sku){
        this.sku = sku;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public void setMrp(Double mrp){
        this.mrp = mrp;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setPacking(String packing){
        this.packing = packing;
    }
    public void setImage(String image){
        this.image = image;
    }
    public void setCategory(Integer category){
        this.category = category;
    }
    public void setStock(Integer stock){
        this.stock = stock;
    }
    public void setStatus(String status){
        this.status = status;
    }
}