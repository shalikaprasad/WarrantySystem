package com.sarc.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Main_Table")
public class Main_Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    private String customer_id_number;
    private String sub_company_name;
    private String item_serial;
    private String invoice_id;
    private Date customer_date_buy;
    private String customer_pay_method;
    private String customer_hire;
    private double customer_payed_amount;

    public Main_Table() {
        super();
    }

    public Main_Table(String customer_id_number, String sub_company_name, String item_serial, String invoice_id, Date customer_date_buy, String customer_pay_method, String customer_hire_method, float customer_payed_amount) {
        this.customer_id_number = customer_id_number;
        this.sub_company_name = sub_company_name;
        this.item_serial = item_serial;
        this.invoice_id = invoice_id;
        this.customer_date_buy = customer_date_buy;
        this.customer_pay_method = customer_pay_method;
        this.customer_hire = customer_hire_method;
        this.customer_payed_amount = customer_payed_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_id_number() {
        return customer_id_number;
    }

    public void setCustomer_id_number(String customer_id_number) {
        this.customer_id_number = customer_id_number;
    }

    public String getSub_company_name() {
        return sub_company_name;
    }

    public void setSub_company_name(String sub_company_name) {
        this.sub_company_name = sub_company_name;
    }

    public String getItem_serial() {
        return item_serial;
    }

    public void setItem_serial(String item_serial) {
        this.item_serial = item_serial;
    }

    public String getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Date getCustomer_date_buy() {
        return customer_date_buy;
    }

    public void setCustomer_date_buy(Date customer_date_buy) {
        this.customer_date_buy = customer_date_buy;
    }

    public String getCustomer_pay_method() {
        return customer_pay_method;
    }

    public void setCustomer_pay_method(String customer_pay_method) {
        this.customer_pay_method = customer_pay_method;
    }

    public String getCustomer_hire() {
        return customer_hire;
    }

    public void setCustomer_hire(String customer_hire_method) {
        this.customer_hire= customer_hire_method;
    }

    public double getCustomer_payed_amount() {
        return customer_payed_amount;
    }

    public void setCustomer_payed_amount(double customer_payed_amount) {
        this.customer_payed_amount = customer_payed_amount;
    }
}
