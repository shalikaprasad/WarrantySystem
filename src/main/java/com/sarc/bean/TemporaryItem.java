package com.sarc.bean;

import javax.persistence.*;

@Entity
@Table(name="temporary_item")
public class TemporaryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private int item_id;

    private String item_serial;
    private String item_type;
    private  String item_brand;
    private String item_warranty;
    private float total_amount;
    private float payed_amount;

    public TemporaryItem() {
    }

    public TemporaryItem(String item_serial, String item_type, String item_brand, String item_warranty, float total_amount, float payed_amount) {
        this.item_serial = item_serial;
        this.item_type = item_type;
        this.item_brand = item_brand;
        this.item_warranty = item_warranty;
        this.total_amount = total_amount;
        this.payed_amount = payed_amount;
    }

    public int getId() {
        return item_id;
    }

    public void setId(int id) {
        this.item_id = id;
    }

    public String getItem_serial() {
        return item_serial;
    }

    public void setItem_serial(String item_serial) {
        this.item_serial = item_serial;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getItem_brand() {
        return item_brand;
    }

    public void setItem_brand(String item_brand) {
        this.item_brand = item_brand;
    }

    public String getItem_warranty() {
        return item_warranty;
    }

    public void setItem_warranty(String item_warranty) {
        this.item_warranty = item_warranty;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }

    public float getPayed_amount() {
        return payed_amount;
    }

    public void setPayed_amount(float payed_amount) {
        this.payed_amount = payed_amount;
    }
}
