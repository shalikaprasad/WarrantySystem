package com.sarc.service;


import com.sarc.bean.Company;
import com.sarc.generic.GenericService;

public interface CompanyService extends GenericService<Company> {

    boolean authenticate(String email, String password);
    Company findByEmail(String email);

}
