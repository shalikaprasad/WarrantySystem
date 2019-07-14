package com.sarc.service.impl;

import com.sarc.service.CheckingService;
import com.sarc.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class CheckingServiceImpl implements CheckingService {
    private String branchName;
    private String companyName;
    private String email;
    private String password1;
    private String password2;
    private String company_address;
    private String branch_address;
    private String phone;
    private String web;
    private String logo;

    ValidationService validationServiceImpl = new ValidationServiceImpl();

    @Override
    public void checking(String companyName, String email, String phone, String password1, String password2) {
        this.companyName = companyName;
        this.email = email;
        this.password1 = password1;
        this.password2 = password2;
        this.phone = phone;
    }

    @Override
    public void checkingCompany(String company_address, String web, String logo) {
        this.company_address = company_address;
        this.web = web;
        this.logo = logo;
    }

    @Override
    public void checkingBranch(String branch_address, String branchName) {
        this.branch_address = branch_address;
        this.branchName = branchName;
    }

    @Override
    public boolean inputValidation(){

        if(
                checkCompanyName(this.companyName) &&
                checkEmail(this.email) &&
                checkPassword(this.password1, this.password2) &&
                checkPhone(this.phone)
        ){
            return true;
        }
        return false;
    }

    @Override
    public boolean inputValidationCompany(){

        if(
                checkWeb(this.web) &&
                checkAddress(this.company_address) &&
                checkLogo(this.logo)
        ){
            return true;
        }
        return false;
    }

    @Override
    public boolean inputValidationBranch(){

        if(
                checkAddress(this.branch_address) &&
                checkBranchName(this.branchName)
        ){
            return true;
        }
        return false;
    }

    private boolean checkBranchName(String branchName){
        if(validationServiceImpl.emptyValidation("Company Name", branchName.isEmpty()) && validationServiceImpl.validate("Company Name", branchName, "[a-zA-Z]+")){
            return true;
        }else {
            return false;
        }
    }

    private boolean checkCompanyName(String companyName){
        if(validationServiceImpl.emptyValidation("Branch Name", companyName.isEmpty())){
            return true;
        }else {
            return false;
        }
    }

    private boolean checkAddress(String address){
        if(validationServiceImpl.emptyValidation("Address", address.isEmpty())){
            return true;
        }else {
            return false;
        }
    }

    private boolean checkPhone(String phone){
        if(validationServiceImpl.emptyValidation("Phone", phone.isEmpty()) ){
            return true;
        }else {
            return false;
        }
    }

    private boolean checkWeb(String web){
        if(validationServiceImpl.emptyValidation("Web", web.isEmpty())){
            return true;
        }else {
            return false;
        }
    }

    private boolean checkLogo(String logo){
        if(validationServiceImpl.emptyValidation("Logo", logo.isEmpty())){
            return true;
        }else {
            return false;
        }
    }

    private boolean checkEmail(String email){
        if(validationServiceImpl.emptyValidation("Email", email.isEmpty()) && validationServiceImpl.validate("Email", email, "[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+")){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean checkPassword(String password1, String password2){
        if(validationServiceImpl.emptyValidation("Password", password1.isEmpty() && validationServiceImpl.emptyValidation("Password", password2.isEmpty())) && validationServiceImpl.notcompare(password1,password2)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void checkAll(){
        validationServiceImpl.emptyValidation("Please Fill All Columns", true);
    }



}
