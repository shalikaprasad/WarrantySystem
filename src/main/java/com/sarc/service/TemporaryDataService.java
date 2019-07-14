package com.sarc.service;


import com.sarc.bean.TemporaryData;

import java.util.List;

public interface TemporaryDataService {
    List<TemporaryData> findAll();
    TemporaryData getDataById(int id);
    void saveOrUpdate(TemporaryData temporaryData);
    void deletebyId(int id);
}
