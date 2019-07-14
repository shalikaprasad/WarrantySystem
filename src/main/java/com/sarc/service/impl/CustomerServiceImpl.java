package com.sarc.service.impl;

import com.sarc.bean.Customer;
import com.sarc.repository.CustomerRepository;
import com.sarc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer save(Customer entity) {
		return customerRepository.save(entity);
	}

	@Override
	public Customer update(Customer entity) {
		return customerRepository.save(entity);
	}

	@Override
	public void delete(Customer entity) {
		customerRepository.delete(entity);
	}

	@Override
	public void deleteInBatch(List<Customer> customers) {
		customerRepository.deleteInBatch(customers);
	}

	@Override
	public List<Customer> findAll() {
			List<Customer> list = new ArrayList<>();
		customerRepository.findAll().forEach(e -> list.add(e));
			return list;
	}

	@Override
	public Customer find(int id) {
		//return companyRepository.findOne(id);
		return null;
	}




}
