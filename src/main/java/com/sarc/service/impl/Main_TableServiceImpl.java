package com.sarc.service.impl;

import com.sarc.bean.Main_Table;
import com.sarc.repository.Main_TableRepository;
import com.sarc.service.Main_TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Main_TableServiceImpl implements Main_TableService {

	@Autowired
	private Main_TableRepository main_tableRepository;

	@Override
	public Main_Table save(Main_Table entity) {
		return main_tableRepository.save(entity);
	}

	@Override
	public Main_Table update(Main_Table entity) {
		return main_tableRepository.save(entity);
	}

	@Override
	public void delete(Main_Table entity) {
		main_tableRepository.delete(entity);
	}

	@Override
	public void deleteInBatch(List<Main_Table> main_tables) {
		main_tableRepository.deleteInBatch(main_tables);
	}

	@Override
	public List<Main_Table> findAll() {
			List<Main_Table> list = new ArrayList<>();
		main_tableRepository.findAll().forEach(e -> list.add(e));
			return list;
	}

	@Override
	public Main_Table find(int id) {
		//return companyRepository.findOne(id);
		return null;
	}




}
