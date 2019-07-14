package com.sarc.generic;

import javafx.scene.control.CheckBox;

public class ListItemService {
    private String serialNumber;
    private String itemType;
    private double itemAmount;
    private String itemBrand;
    private String itemWarranty;
    private double itemPayedAmount;
    private double itemDiscount;
    private CheckBox itemHire;
    private boolean hire;

    public ListItemService() {
        super();
    }

    public ListItemService(String serialNumber, String itemType, String itemBrand, String itemWarranty, double itemAmount,double itemPayedAmount, double itemDiscount) {
        super();
        this.serialNumber = serialNumber;
        this.itemType = itemType;
        this.itemAmount = itemAmount;
        this.itemWarranty = itemWarranty;
        this.itemPayedAmount = itemPayedAmount;
        this.itemDiscount = itemDiscount;
        this.itemBrand = itemBrand;
        this.itemHire = new CheckBox();
    }
    public ListItemService(double itemPayedAmount){
        this.itemPayedAmount = itemPayedAmount;
    }



    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(double itemAmount) {
        this.itemAmount = itemAmount;
    }

    public double getItemDiscount() {
        return itemDiscount;
    }

    public void setItemDiscount(double itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public CheckBox getItemHire() {
        return itemHire;
    }

    public void setItemHire(CheckBox itemHire) {
        this.itemHire = itemHire;
    }

    public double getItemPayedAmount() {
        return itemPayedAmount;
    }

    public void setItemPayedAmount(double itemPayedAmount) {
        this.itemPayedAmount = itemPayedAmount;
    }

    public boolean isHire() {
        return hire;
    }

    public void setHire(boolean hire) {
        this.hire = hire;
    }

    public String getItemBrand() {
        return itemBrand;
    }

    public void setItemBrand(String itemBrand) {
        this.itemBrand = itemBrand;
    }

    public String getItemWarranty() {
        return itemWarranty;
    }

    public void setItemWarranty(String itemWarranty) {
        this.itemWarranty = itemWarranty;
    }
}
