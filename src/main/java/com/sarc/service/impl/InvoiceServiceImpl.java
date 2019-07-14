package com.sarc.service.impl;

import com.sarc.bean.Invoice;
import com.sarc.repository.InvoiceRepository;
import com.sarc.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Override
	public Invoice save(Invoice entity) {
		return invoiceRepository.save(entity);
	}

	@Override
	public Invoice update(Invoice entity) {
		return invoiceRepository.save(entity);
	}

	@Override
	public void delete(Invoice entity) {
		invoiceRepository.delete(entity);
	}

	@Override
	public void deleteInBatch(List<Invoice> item_brands) {
		invoiceRepository.deleteInBatch(item_brands);
	}

	@Override
	public List<Invoice> findAll() {
			List<Invoice> list = new ArrayList<>();
		invoiceRepository.findAll().forEach(e -> list.add(e));
			return list;
	}

	@Override
	public Invoice find(int id) {
		//return companyRepository.findOne(id);
		return null;
	}




}
