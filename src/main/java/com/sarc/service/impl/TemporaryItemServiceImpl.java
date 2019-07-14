package com.sarc.service.impl;

import com.sarc.bean.TemporaryItem;
import com.sarc.repository.TemporaryItemRepository;
import com.sarc.service.TemporaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemporaryItemServiceImpl implements TemporaryItemService {

    @Autowired
    TemporaryItemRepository temporaryItemRepository;

    @Override
    public TemporaryItem save(TemporaryItem entity) {
        return temporaryItemRepository.save(entity);
    }

    @Override
    public TemporaryItem update(TemporaryItem entity) {
        return temporaryItemRepository.save(entity);
    }

    @Override
    public void delete(TemporaryItem entity) {
        temporaryItemRepository.delete(entity);
    }

    @Override
    public void deleteInBatch(List<TemporaryItem> branches) {
        temporaryItemRepository.deleteInBatch(branches);
    }

    @Override
    public List<TemporaryItem> findAll() {
        List<TemporaryItem> list = new ArrayList<>();
        temporaryItemRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public TemporaryItem find(int id) {
        //return companyRepository.findOne(id);
        return null;
    }


}
