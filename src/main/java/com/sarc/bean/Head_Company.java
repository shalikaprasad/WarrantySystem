package com.sarc.bean;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Set;

@Entity
@Table(name="Head_Company")
public class Head_Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "headcompany_id", nullable = false)
    private int headcompany_id;

    private String headcompany_name;
    private String headcompany_address;
    private String headcompany_phone;
    private String headcompany_web;
    private String headcompany_email;
    private String headcompany_password;
    private Blob headcompany_logo;

    @OneToMany(mappedBy="headcompany_map",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Sub_Company> sub_companie_head;

    public Head_Company() {
        super();
    }

    public Head_Company(String headcompany_name, String headcompany_address, String headcompany_phone, String headcompany_web, String headcompany_email, String headcompany_password, Blob headcompany_logo, Set<Sub_Company> sub_companie_head) {
        super();
        this.headcompany_name = headcompany_name;
        this.headcompany_address = headcompany_address;
        this.headcompany_phone = headcompany_phone;
        this.headcompany_web = headcompany_web;
        this.headcompany_email = headcompany_email;
        this.headcompany_password = headcompany_password;
        this.headcompany_logo = headcompany_logo;
        this.sub_companie_head = sub_companie_head;
    }

    public int getHeadcompany_id() {
        return headcompany_id;
    }

    public void setHeadcompany_id(int headcompany_id) {
        this.headcompany_id = headcompany_id;
    }

    public String getHeadcompany_name() {
        return headcompany_name;
    }

    public void setHeadcompany_name(String headcompany_name) {
        this.headcompany_name = headcompany_name;
    }

    public String getHeadcompany_address() {
        return headcompany_address;
    }

    public void setHeadcompany_address(String headcompany_address) {
        this.headcompany_address = headcompany_address;
    }

    public String getHeadcompany_phone() {
        return headcompany_phone;
    }

    public void setHeadcompany_phone(String headcompany_phone) {
        this.headcompany_phone = headcompany_phone;
    }

    public String getHeadcompany_web() {
        return headcompany_web;
    }

    public void setHeadcompany_web(String headcompany_web) {
        this.headcompany_web = headcompany_web;
    }

    public String getHeadcompany_email() {
        return headcompany_email;
    }

    public void setHeadcompany_email(String headcompany_email) {
        this.headcompany_email = headcompany_email;
    }

    public String getHeadcompany_password() {
        return headcompany_password;
    }

    public void setHeadcompany_password(String headcompany_password) {
        this.headcompany_password = headcompany_password;
    }

    public Set<Sub_Company> getSub_companie_head() {
        return sub_companie_head;
    }

    public void setSub_companie_head(Set<Sub_Company> sub_companie_head) {
        this.sub_companie_head = sub_companie_head;
    }

    public Blob getHeadcompany_logo() {
        return headcompany_logo;
    }

    public void setHeadcompany_logo(Blob headcompany_logo) {
        this.headcompany_logo = headcompany_logo;
    }

    @Override
    public String toString() {
        return "Head_Company{" +
                "headcompany_id=" + headcompany_id +
                ", headcompany_name='" + headcompany_name + '\'' +
                ", headcompany_address='" + headcompany_address + '\'' +
                ", headcompany_phone='" + headcompany_phone + '\'' +
                ", headcompany_web='" + headcompany_web + '\'' +
                ", headcompany_email='" + headcompany_email + '\'' +
                ", headcompany_password='" + headcompany_password + '\'' +
                ", headcompany_logo=" + headcompany_logo +
                ", sub_companie_head=" + sub_companie_head +
                '}';
    }
}