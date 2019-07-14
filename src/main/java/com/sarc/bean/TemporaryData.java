package com.sarc.bean;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="temporary_data")
public class TemporaryData {

    @Id
    private int id;

    private String phoneNumber;
    private String email;
    private  int branch_id;
    private String branchName;
    private String company_address;
    private String company_web;
    private Date date;
    public TemporaryData() {
    }

    public TemporaryData(int id, String phoneNumber, String email, int branch_id, String branchName, String company_address, String company_web, Date date) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.branch_id = branch_id;
        this.branchName = branchName;
        this.company_address = company_address;
        this.company_web = company_web;
        this.date = date;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBranchId() {
        return branch_id;
    }

    public void setBranchId(int branch_id) {
        this.branch_id = branch_id;
    }

    public String getCompany_address() {
        return company_address;
    }

    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    public String getCompany_web() {
        return company_web;
    }

    public void setCompany_web(String company_web) {
        this.company_web = company_web;
    }
}
