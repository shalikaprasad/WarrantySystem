package com.sarc.generic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListService {


    private ObservableList<String> listbranch = FXCollections.observableArrayList(
            "Horana",
            "Colombo",
            "Kelaniya",
            "Gampaha",
            "Anuradhapura",
            "Galle",
            "Hambantota",
            "Jaffna",
            "Kandy",
            "Kurunegala",
            "Matara",
            "Monaragala",
            "Nuwara Eliya"
    );

    private ObservableList<String> listtype = FXCollections.observableArrayList(
            "Laptop",
            "Phone",
            "Keybourd",
            "Mouse",
            "Pen_Drive"
    );

    private ObservableList<String> brandtype_lap = FXCollections.observableArrayList(
            "HP",
            "Acer",
            "AGC",
            "Microsoft",
            "dell",
            "Lenovo"
    );

    private ObservableList<String> brandtype_phone = FXCollections.observableArrayList(
            "Lava",
            "Apple",
            "LES3",
            "Nokia",
            "Microsoft",
            "Bird"
    );

    private ObservableList<String> brandtype_Keybourd = FXCollections.observableArrayList(
            "Yamaha",
            "Casio",
            "Roland",
            "Kawai",
            "Korg"
    );

    private ObservableList<String> brandtype_Mouse = FXCollections.observableArrayList(
            "Yamaha",
            "Casio",
            "Roland",
            "Kawai",
            "Korg"
    );

    private ObservableList<String> brandtype_Pen = FXCollections.observableArrayList(
            "Kingston",
            "SanDisk",
            "Samsung",
            "PNY",
            "Patrot"
    );

    private ObservableList<String> listhardware = FXCollections.observableArrayList(
            "No Warranty",
            "3 Months",
            "6 Months",
            "1 Year",
            "2 Year",
            "3 Year",
            "4 Year",
            "5 Year"
    );

    private ObservableList<String> listsoftware = FXCollections.observableArrayList(
            "No Warranty",
            "3 Months",
            "6 Months",
            "1 Year",
            "2 Year",
            "3 Year",
            "4 Year",
            "5 Year"
    );

    private ObservableList<String> listfiled1 = FXCollections.observableArrayList(
            "Serial Number",
            "Item Name",
            "Brand Name",
            "Warranty Hardware",
            "Warranty Software",
            "Customer Name",
            "Date Buy",
            "Phone Number",
            "Pay Method",
            "Exprire",
            "Sold"
    );

    public ObservableList<String> getListbranch() {
        return listbranch;
    }

    public void setListbranch(ObservableList<String> listbranch) {
        this.listbranch = listbranch;
    }

    public ObservableList<String> getListtype() {
        return listtype;
    }

    public void setListtype(ObservableList<String> listtype) {
        this.listtype = listtype;
    }

    public ObservableList<String> getBrandtype_lap() {
        return brandtype_lap;
    }

    public void setBrandtype_lap(ObservableList<String> brandtype_lap) {
        this.brandtype_lap = brandtype_lap;
    }

    public ObservableList<String> getBrandtype_phone() {
        return brandtype_phone;
    }

    public void setBrandtype_phone(ObservableList<String> brandtype_phone) {
        this.brandtype_phone = brandtype_phone;
    }

    public ObservableList<String> getBrandtype_Keybourd() {
        return brandtype_Keybourd;
    }

    public void setBrandtype_Keybourd(ObservableList<String> brandtype_Keybourd) {
        this.brandtype_Keybourd = brandtype_Keybourd;
    }

    public ObservableList<String> getBrandtype_Mouse() {
        return brandtype_Mouse;
    }

    public void setBrandtype_Mouse(ObservableList<String> brandtype_Mouse) {
        this.brandtype_Mouse = brandtype_Mouse;
    }

    public ObservableList<String> getBrandtype_Pen() {
        return brandtype_Pen;
    }

    public void setBrandtype_Pen(ObservableList<String> brandtype_Pen) {
        this.brandtype_Pen = brandtype_Pen;
    }

    public ObservableList<String> getListhardware() {
        return listhardware;
    }

    public void setListhardware(ObservableList<String> listhardware) {
        this.listhardware = listhardware;
    }

    public ObservableList<String> getListsoftware() {
        return listsoftware;
    }

    public void setListsoftware(ObservableList<String> listsoftware) {
        this.listsoftware = listsoftware;
    }

    public ObservableList<String> getListfiled1() {
        return listfiled1;
    }

    public void setListfiled1(ObservableList<String> listfiled1) {
        this.listfiled1 = listfiled1;
    }



}
