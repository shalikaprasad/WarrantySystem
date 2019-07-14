package com.sarc.bean;

import javax.persistence.*;

@Entity
@Table(name="Item_Category")
public class Item_Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_category_id", nullable = false)
    private int item_category_id;
    private String item_category_name;


    public Item_Category() {
        super();
    }

    public int getItem_category_id() {
        return item_category_id;
    }

    public void setItem_category_id(int item_category_id) {
        this.item_category_id = item_category_id;
    }

    public String getItem_category_name() {
        return item_category_name;
    }

    public void setItem_category_name(String item_category_name) {
        this.item_category_name = item_category_name;
    }
}