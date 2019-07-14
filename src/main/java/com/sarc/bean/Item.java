package com.sarc.bean;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Set;

@Entity
@Table(name="Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_serial_number_id", nullable = false)
    private int item_serial_number_id;

    private String item_serial_number;
    private int item_brand_id;
    private int supplier_id;
    private int item_category_id;
    private int item_sell_amount_id;


    private double item_discounts;
    private double item_buy_amount;
    private String item_warranty_hardware;
    private String item_warranty_software;
    private Blob item_qrcode;
    private boolean item_sold;
    private boolean item_expire;
    private int item_repair;

    public Item() {
        super();
    }

    public int getItem_serial_number_id() {
        return item_serial_number_id;
    }

    public void setItem_serial_number_id(int item_serial_number_id) {
        this.item_serial_number_id = item_serial_number_id;
    }

    public String getItem_serial_number() {
        return item_serial_number;
    }

    public void setItem_serial_number(String item_serial_number) {
        this.item_serial_number = item_serial_number;
    }

    public int getItem_brand_id() {
        return item_brand_id;
    }

    public void setItem_brand_id(int item_brand_id) {
        this.item_brand_id = item_brand_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getItem_category_id() {
        return item_category_id;
    }

    public void setItem_category_id(int item_category_id) {
        this.item_category_id = item_category_id;
    }

    public int getItem_sell_amount_id() {
        return item_sell_amount_id;
    }

    public void setItem_sell_amount_id(int item_sell_amount_id) {
        this.item_sell_amount_id = item_sell_amount_id;
    }


    public double getItem_discounts() {
        return item_discounts;
    }

    public void setItem_discounts(double item_discounts) {
        this.item_discounts = item_discounts;
    }

    public double getItem_buy_amount() {
        return item_buy_amount;
    }

    public void setItem_buy_amount(double item_buy_amount) {
        this.item_buy_amount = item_buy_amount;
    }

    public String getItem_warranty_hardware() {
        return item_warranty_hardware;
    }

    public void setItem_warranty_hardware(String item_warranty_hardware) {
        this.item_warranty_hardware = item_warranty_hardware;
    }

    public String getItem_warranty_software() {
        return item_warranty_software;
    }

    public void setItem_warranty_software(String item_warranty_software) {
        this.item_warranty_software = item_warranty_software;
    }

    public Blob getItem_qrcode() {
        return item_qrcode;
    }

    public void setItem_qrcode(Blob item_qrcode) {
        this.item_qrcode = item_qrcode;
    }

    public boolean isItem_sold() {
        return item_sold;
    }

    public void setItem_sold(boolean item_sold) {
        this.item_sold = item_sold;
    }

    public boolean isItem_expire() {
        return item_expire;
    }

    public void setItem_expire(boolean item_expire) {
        this.item_expire = item_expire;
    }

    public int getItem_repair() {
        return item_repair;
    }

    public void setItem_repair(int item_repair) {
        this.item_repair = item_repair;
    }
}
