package com.sarc.service.impl;

import com.sarc.bean.Sub_Company;
import com.sarc.repository.Sub_CompanyRepository;
import com.sarc.service.Sub_CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Sub_CompanyServiceImpl implements Sub_CompanyService {

	@Autowired
	private Sub_CompanyRepository sub_companyRepository;

	Sub_Company return_sub_company;

	@Override
	public Sub_Company save(Sub_Company entity) {
		return sub_companyRepository.save(entity);
	}

	@Override
	public Sub_Company update(Sub_Company entity) {
		return sub_companyRepository.save(entity);
	}

	@Override
	public void delete(Sub_Company entity) {
		sub_companyRepository.delete(entity);
	}

	@Override
	public void deleteInBatch(List<Sub_Company> sub_companies) {
		sub_companyRepository.deleteInBatch(sub_companies);
	}

	@Override
	public List<Sub_Company> findAll() {
			List<Sub_Company> list = new ArrayList<>();
		sub_companyRepository.findAll().forEach(e -> list.add(e));
			return list;
	}

	@Override
	public Sub_Company find(int id) {
		//return companyRepository.findOne(id);
		return null;
	}

	@Override
	public boolean authenticate(String phoneNumber, String password){

		List<Sub_Company> sub_companyList = this.findAll();
		boolean checkphone = false;

		for (Sub_Company sub_company : sub_companyList) {
			if (!phoneNumber.equals(sub_company.getSubcompany_phone())) {
				this.return_sub_company = sub_company;
				break;

			} else {
				if (password.equals(sub_company.getSubcompany_password())){
					checkphone = true;
				}
			}

		}
		return checkphone;
	}

	@Override
	public Sub_Company getReturn_sub_company(){
		return this.return_sub_company;
	}

}
