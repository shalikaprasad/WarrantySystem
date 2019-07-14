package com.sarc.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private int customer_id;

    private String customer_identity_number;
    private String customer_name;
    private String customer_address;
    private String customer_email;
    private String customer_phone;


    public Customer() {
        super();
    }

    public Customer(String customer_identity_number, String customer_name, String customer_address, String customer_email, String customer_phone, Set<Main_Table> main_table_customer) {
        super();
        this.customer_identity_number = customer_identity_number;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.customer_email = customer_email;
        this.customer_phone = customer_phone;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_identity_number() {
        return customer_identity_number;
    }

    public void setCustomer_identity_number(String customer_identity_number) {
        this.customer_identity_number = customer_identity_number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_emai() {
        return customer_email;
    }

    public void setCustomer_emai(String customer_emai) {
        this.customer_email = customer_emai;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }



    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_identity_number='" + customer_identity_number + '\'' +
                ", customer_name='" + customer_name + '\'' +
                ", customer_address='" + customer_address + '\'' +
                ", customer_email='" + customer_email + '\'' +
                ", customer_phone='" + customer_phone + '\'' +
                '}';
    }
}
