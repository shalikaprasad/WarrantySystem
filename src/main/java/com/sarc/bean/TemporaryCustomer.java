package com.sarc.bean;


import javax.persistence.*;


@Entity
@Table(name="temporary_customer")
public class TemporaryCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private int id;

    private String cus_name;
    private String cus_id;
    private  String cus_address;
    private String cus_phone;
    private String cus_pay_method;

    public TemporaryCustomer() {
    }

    public TemporaryCustomer(String cus_name, String cus_id, String cus_address, String cus_phone, String cus_pay_method) {
        this.cus_name = cus_name;
        this.cus_id = cus_id;
        this.cus_address = cus_address;
        this.cus_phone = cus_phone;
        this.cus_pay_method = cus_pay_method;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_id() {
        return cus_id;
    }

    public void setCus_id(String cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_address() {
        return cus_address;
    }

    public void setCus_address(String cus_address) {
        this.cus_address = cus_address;
    }

    public String getCus_phone() {
        return cus_phone;
    }

    public void setCus_phone(String cus_phone) {
        this.cus_phone = cus_phone;
    }

    public String getCus_pay_method() {
        return cus_pay_method;
    }

    public void setCus_pay_method(String cus_pay_method) {
        this.cus_pay_method = cus_pay_method;
    }
}
