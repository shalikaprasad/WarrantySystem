package com.sarc.service.impl;

import com.sarc.bean.Head_Company;
import com.sarc.repository.Head_CompanyRepository;
import com.sarc.service.Head_CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Head_CompanyServiceImpl implements Head_CompanyService {

	@Autowired
	private Head_CompanyRepository head_companyRepository;

//	@Override
//	public Head_Company findByCompanyName(String headcompany_name) {
//		return head_companyRepository.findByCompanyName(headcompany_name);
//	}

	@Override
	public Head_Company save(Head_Company entity) {
		return head_companyRepository.save(entity);
	}

	@Override
	public Head_Company update(Head_Company entity) {
		return head_companyRepository.save(entity);
	}

	@Override
	public void delete(Head_Company entity) {
		head_companyRepository.delete(entity);
	}

	@Override
	public void deleteInBatch(List<Head_Company> head_companies) {
		head_companyRepository.deleteInBatch(head_companies);
	}

	@Override
	public List<Head_Company> findAll() {
			List<Head_Company> list = new ArrayList<>();
		head_companyRepository.findAll().forEach(e -> list.add(e));
			return list;
	}

	@Override
	public Head_Company find(int id) {
		//return companyRepository.findOne(id);
		return null;
	}

}
