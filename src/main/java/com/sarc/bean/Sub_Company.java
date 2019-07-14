package com.sarc.bean;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="Sub_Company")
public class Sub_Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcompany_id", nullable = false)
    private int subcompany_id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "headcompany_id")
    private Head_Company headcompany_map;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "subcompany_branch_id")
    private Branch subcompany_branch_map;

    private String subcompany_address;
    private String subcompany_password;
    private String subcompany_phone;


    public Sub_Company() {
        super();
    }

    public Sub_Company(Head_Company headcompany_map, Branch subcompany_branch_map, String subcompany_address, String subcompany_password, String subcompany_phone, Set<Main_Table> main_table_subcompany) {
        super();
        this.headcompany_map = headcompany_map;
        this.subcompany_branch_map = subcompany_branch_map;
        this.subcompany_address = subcompany_address;
        this.subcompany_password = subcompany_password;
        this.subcompany_phone = subcompany_phone;

    }

    public int getSubcompany_id() {
        return subcompany_id;
    }

    public void setSubcompany_id(int subcompany_id) {
        this.subcompany_id = subcompany_id;
    }

    public Head_Company getHeadcompany_map() {
        return headcompany_map;
    }

    public void setHeadcompany_map(Head_Company headcompany_map) {
        this.headcompany_map = headcompany_map;
    }

    public Branch getSubcompany_branch_map() {
        return subcompany_branch_map;
    }

    public void setSubcompany_branch_map(Branch subcompany_branch_map) {
        this.subcompany_branch_map = subcompany_branch_map;
    }

    public String getSubcompany_address() {
        return subcompany_address;
    }

    public void setSubcompany_address(String subcompany_address) {
        this.subcompany_address = subcompany_address;
    }

    public String getSubcompany_password() {
        return subcompany_password;
    }

    public void setSubcompany_password(String subcompany_password) {
        this.subcompany_password = subcompany_password;
    }

    public String getSubcompany_phone() {
        return subcompany_phone;
    }

    public void setSubcompany_phone(String subcompany_phone) {
        this.subcompany_phone = subcompany_phone;
    }



    @Override
    public String toString() {
        return "Sub_Company{" +
                "subcompany_id=" + subcompany_id +
                ", headcompany_map=" + headcompany_map +
                ", subcompany_branch_map=" + subcompany_branch_map +
                ", subcompany_address='" + subcompany_address + '\'' +
                ", subcompany_password='" + subcompany_password + '\'' +
                ", subcompany_phone='" + subcompany_phone + '\'' +
                '}';
    }
}
