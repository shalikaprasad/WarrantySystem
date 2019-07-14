package com.sarc.service.impl;

import com.sarc.bean.Supplier;
import com.sarc.repository.SupplierRepository;
import com.sarc.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	@Override
	public Supplier save(Supplier entity) {
		return supplierRepository.save(entity);
	}

	@Override
	public Supplier update(Supplier entity) {
		return supplierRepository.save(entity);
	}

	@Override
	public void delete(Supplier entity) {
		supplierRepository.delete(entity);
	}

	@Override
	public void deleteInBatch(List<Supplier> suppliers) {
		supplierRepository.deleteInBatch(suppliers);
	}

	@Override
	public List<Supplier> findAll() {
			List<Supplier> list = new ArrayList<>();
		supplierRepository.findAll().forEach(e -> list.add(e));
			return list;
	}

	@Override
	public Supplier find(int id) {
		//return companyRepository.findOne(id);
		return null;
	}




}
