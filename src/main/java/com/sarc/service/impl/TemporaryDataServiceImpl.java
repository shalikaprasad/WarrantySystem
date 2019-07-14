package com.sarc.service.impl;

import com.sarc.bean.Company;
import com.sarc.bean.TemporaryData;
import com.sarc.repository.TemporaryDataRepository;
import com.sarc.service.TemporaryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TemporaryDataServiceImpl implements TemporaryDataService {

    @Autowired
    TemporaryDataRepository temporaryDataRepository;

    @Override
    public TemporaryData getDataById(int id) {
        try{
            return temporaryDataRepository.findById(id).get();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void saveOrUpdate(TemporaryData temporaryData) {
        temporaryDataRepository.save(temporaryData);
    }

    @Override
    public void deletebyId(int id) {
        temporaryDataRepository.deleteById(id);
    }

    @Override
    public List<TemporaryData> findAll() {
        return temporaryDataRepository.findAll();
    }
}
