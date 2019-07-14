package com.sarc.service;


import com.sarc.bean.SingerItems;
import com.sarc.generic.GenericService;

import java.util.List;

public interface SingerItemService extends GenericService<SingerItems> {
    List<SingerItems> findAll();
    SingerItems findBySerialNumber(String serialNumber);
}
