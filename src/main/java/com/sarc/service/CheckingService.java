package com.sarc.service;

public interface CheckingService {


    void checking(String companyName, String email, String phone, String password1, String password2);
    void checkingCompany(String company_address,String web, String logo);
    void checkingBranch(String branch_address, String branchName);
    boolean inputValidationCompany();
    boolean inputValidationBranch();
    boolean inputValidation();
    boolean checkPassword(String password1, String password2);
    void checkAll();
}
