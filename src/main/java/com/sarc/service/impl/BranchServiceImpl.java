package com.sarc.service.impl;

import com.sarc.bean.Branch;
import com.sarc.repository.BranchRepository;
import com.sarc.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepository branchRepository;

//	@Override
//	public Branch findByBranch(String subcompany_branch_name) {
//		return branchRepository.findByBranch(subcompany_branch_name);
//	}

	@Override
	public Branch save(Branch entity) {
		return branchRepository.save(entity);
	}

	@Override
	public Branch update(Branch entity) {
		return branchRepository.save(entity);
	}

	@Override
	public void delete(Branch entity) {
		branchRepository.delete(entity);
	}

	@Override
	public void deleteInBatch(List<Branch> branches) {
		branchRepository.deleteInBatch(branches);
	}

	@Override
	public List<Branch> findAll() {
			List<Branch> list = new ArrayList<>();
		 	branchRepository.findAll().forEach(e -> list.add(e));
			return list;
	}

	@Override
	public Branch find(int id) {
		//return companyRepository.findOne(id);
		return null;
	}




}
