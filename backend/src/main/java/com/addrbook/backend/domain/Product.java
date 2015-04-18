package com.addrbook.backend.domain;

import javax.validation.constraints.NotNull;

/**
 * Created by alexandr on 08.04.15.
 */
public class Product {
    private Integer id;
    private Integer sku;
//    @Size(max = 64)
    @NotNull(message = "Message name must not be blank!")
    private String name;
//    @Size(max = 64)
    @NotNull(message = "Message price must not be blank!")
    private Double price;
    private Double mrp;
//    @Size(max = 64)
    @NotNull(message = "Message description must not be blank!")
    private String description;
//    @Size(max = 64)
    @NotNull(message = "Message packing must not be blank!")
    private String packing;
    private String image;
//    @Size(max = 64)
    @NotNull(message = "Message category must not be blank!")
    private Integer category;
//    @Size(max = 64)
    @NotNull(message = "Message stock must not be blank!")
    private Integer stock;
//    @Size(max = 64)
    @NotNull(message = "Message status must not be blank!")
    private String status;

    public Product(){}
    public Product(Integer id, Integer sku, String name, Double price, Double mrp, String description, String packing, String image, Integer category, Integer stock, String status){
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.mrp = mrp;
        this.description = description;
        this.packing = packing;
        this.image = image;
        this.category = category;
        this.stock = stock;
        this.status = status;
    }
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

    // https://plugins.jetbrains.com/plugin/7244?pr=
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku=" + sku +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", mrp=" + mrp +
                ", description='" + description + '\'' +
                ", packing='" + packing + '\'' +
                ", image='" + image + '\'' +
                ", category=" + category +
                ", stock=" + stock +
                ", status='" + status + '\'' +
                '}';
    }
}