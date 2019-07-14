package com.sarc.service.impl;

import com.sarc.bean.TemporaryCustomer;
import com.sarc.repository.TemporaryCustomerRepository;
import com.sarc.service.TemporaryCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TemporaryCustomerServiceImpl implements TemporaryCustomerService {

    @Autowired
    TemporaryCustomerRepository temporaryCustomerRepository;

    @Override
    public TemporaryCustomer getDataById(int id) {
        try{
            return temporaryCustomerRepository.findById(id).get();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void saveOrUpdate(TemporaryCustomer temporaryCustomer) {
        temporaryCustomerRepository.save(temporaryCustomer);
    }

    @Override
    public void deletebyId(int id) {
        temporaryCustomerRepository.deleteById(id);
    }

    @Override
    public List<TemporaryCustomer> findAll() {
        return temporaryCustomerRepository.findAll();
    }

    @Override
    public void delete(TemporaryCustomer entity) {
        temporaryCustomerRepository.delete(entity);
    }
}
