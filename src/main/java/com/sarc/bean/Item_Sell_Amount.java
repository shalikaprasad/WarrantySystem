package com.sarc.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Item_Sell_Amount")
public class Item_Sell_Amount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_sell_amount_id", nullable = false)
    private int item_sell_amount_id;

    private double item_sell_amount_value;
    private double item_down_payment;
    private double item_monthly_payment;
    private double item_interes;


    public Item_Sell_Amount() {
        super();
    }

    public int getItem_sell_amount_id() {
        return item_sell_amount_id;
    }

    public void setItem_sell_amount_id(int item_sell_amount_id) {
        this.item_sell_amount_id = item_sell_amount_id;
    }

    public double getItem_sell_amount_value() {
        return item_sell_amount_value;
    }

    public void setItem_sell_amount_value(double item_sell_amount_value) {
        this.item_sell_amount_value = item_sell_amount_value;
    }

    public double getItem_down_payment() {
        return item_down_payment;
    }

    public void setItem_down_payment(double item_down_payment) {
        this.item_down_payment = item_down_payment;
    }

    public double getItem_monthly_payment() {
        return item_monthly_payment;
    }

    public void setItem_monthly_payment(double item_monthly_payment) {
        this.item_monthly_payment = item_monthly_payment;
    }

    public double getItem_interes() {
        return item_interes;
    }

    public void setItem_interes(double item_interes) {
        this.item_interes = item_interes;
    }
}