package com.sarc.service;


import com.sarc.bean.TemporaryCustomer;

import java.util.List;

public interface TemporaryCustomerService {
    List<TemporaryCustomer> findAll();
    TemporaryCustomer getDataById(int id);
    void saveOrUpdate(TemporaryCustomer temporaryCustomer);
    void deletebyId(int id);
    void delete(TemporaryCustomer entity);
}
