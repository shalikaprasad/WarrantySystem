package com.sarc.service.impl;

import com.sarc.bean.Company;
import com.sarc.repository.CompanyRepository;
import com.sarc.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company findByEmail(String email) {
		return companyRepository.findByEmail(email);
	}

	@Override
	public Company save(Company entity) {
		return companyRepository.save(entity);
	}

	@Override
	public Company update(Company entity) {
		return companyRepository.save(entity);
	}

	@Override
	public void delete(Company entity) {
		companyRepository.delete(entity);
	}

	@Override
	public void deleteInBatch(List<Company> companies) {
		companyRepository.deleteInBatch(companies);
	}

	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	@Override
	public Company find(int id) {
		//return companyRepository.findOne(id);
		return null;
	}

	@Override
	public boolean authenticate(String email, String password){

		Company company = this.findByEmail(email);

		if(company == null){
			return false;

		}else{
			if(password.equals(company.getPassword1())) return true;
			else return false;
		}
	}

}
