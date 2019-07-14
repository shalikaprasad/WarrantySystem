package com.sarc.service;


import com.sarc.bean.Head_Company;
import com.sarc.bean.Sub_Company;
import com.sarc.generic.GenericService;

public interface Sub_CompanyService extends GenericService<Sub_Company> {
    boolean authenticate(String phoneNumber, String password);
    Sub_Company getReturn_sub_company();
}
