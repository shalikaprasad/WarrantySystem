package com.sarc.bean;

import javax.persistence.*;

@Entity
@Table(name="Item_Brand")
public class Item_Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_brand_id", nullable = false)
    private int item_brand_id;

    private String item_brand_name;

    public Item_Brand() {
        super();
    }

    public int getItem_brand_id() {
        return item_brand_id;
    }

    public void setItem_brand_id(int item_brand_id) {
        this.item_brand_id = item_brand_id;
    }

    public String getItem_brand_name() {
        return item_brand_name;
    }

    public void setItem_brand_name(String item_brand_name) {
        this.item_brand_name = item_brand_name;
    }
}