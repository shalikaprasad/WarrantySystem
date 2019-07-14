package com.sarc.service.impl;

import com.sarc.bean.Item_Category;
import com.sarc.repository.Item_CategoryRepository;
import com.sarc.service.Item_CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Item_CategoryServiceImpl implements Item_CategoryService {

	@Autowired
	private Item_CategoryRepository item_categoryRepository;


	@Override
	public Item_Category save(Item_Category entity) {
		return item_categoryRepository.save(entity);
	}

	@Override
	public Item_Category update(Item_Category entity) {
		return item_categoryRepository.save(entity);
	}

	@Override
	public void delete(Item_Category entity) {
		item_categoryRepository.delete(entity);
	}

	@Override
	public void deleteInBatch(List<Item_Category> item_categories) {
		item_categoryRepository.deleteInBatch(item_categories);
	}

	@Override
	public List<Item_Category> findAll() {
			List<Item_Category> list = new ArrayList<>();
		item_categoryRepository.findAll().forEach(e -> list.add(e));
			return list;
	}

	@Override
	public Item_Category find(int id) {
		//return companyRepository.findOne(id);
		return null;
	}

}
