package com.sarc.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Branch")
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcompany_branch_id", nullable = false)
    private int subcompany_branch_id;

    private String  subcompany_branch_name;

    @OneToMany(mappedBy="subcompany_branch_map",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Sub_Company> sub_company_branch;

    public Branch() {
    }

    public Branch(String subcompany_branch_name, Set<Sub_Company> sub_company_branch) {
        this.subcompany_branch_name = subcompany_branch_name;
        this.sub_company_branch = sub_company_branch;
    }

    public int getSubcompany_branch_id() {
        return subcompany_branch_id;
    }

    public void setSubcompany_branch_id(int subcompany_branch_id) {
        this.subcompany_branch_id = subcompany_branch_id;
    }

    public String getSubcompany_branch_name() {
        return subcompany_branch_name;
    }

    public void setSubcompany_branch_name(String subcompany_branch_name) {
        this.subcompany_branch_name = subcompany_branch_name;
    }

    public Set<Sub_Company> getSub_company_branch() {
        return sub_company_branch;
    }

    public void setSub_company_branch(Set<Sub_Company> sub_company_branch) {
        this.sub_company_branch = sub_company_branch;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "subcompany_branch_id=" + subcompany_branch_id +
                ", subcompany_branch_name='" + subcompany_branch_name + '\'' +
                ", sub_company_branch=" + sub_company_branch +
                '}';
    }
}