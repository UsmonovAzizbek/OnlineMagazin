package org.example.controller.model;

public class Product {
    private Integer id;
    private String category;
    private String type;
    private String subtype;
    private String name;
    private String description;
    private Integer price;

    public Product(Integer id, String category, String type, String subtype, String name, String description, Integer price) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.subtype = subtype;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String category, String type, String subType, String name, String description, int price) {

    }

    public Product() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
