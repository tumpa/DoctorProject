package com.example.tumpa.cardviewtest;

/**
 * Created by tumpa on 1/14/2016.
 */
public class Category {
    String categoryID;
    String categoryField;

    public Category(String categoryField) {
        this.categoryField = categoryField;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryID='" + categoryID + '\'' +
                ", categoryField='" + categoryField + '\'' +
                '}';
    }

    public Category(String categoryID, String categoryField) {
        this.categoryID = categoryID;
        this.categoryField = categoryField;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryField() {
        return categoryField;
    }

    public void setCategoryField(String categoryField) {
        this.categoryField = categoryField;
    }
}
