package com.sarc.service.impl;

import com.sarc.bean.Item_Brand;
import com.sarc.repository.Item_BrandRepository;
import com.sarc.service.Item_BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class Item_BrandServiceImpl implements Item_BrandService {

	@Autowired
	private Item_BrandRepository item_brandRepository;

	@Override
	public Item_Brand save(Item_Brand entity) {
		return item_brandRepository.save(entity);
	}

	@Override
	public Item_Brand update(Item_Brand entity) {
		return item_brandRepository.save(entity);
	}

	@Override
	public void delete(Item_Brand entity) {
		item_brandRepository.delete(entity);
	}

	@Override
	public void deleteInBatch(List<Item_Brand> item_brands) {
		item_brandRepository.deleteInBatch(item_brands);
	}

	@Override
	public List<Item_Brand> findAll() {
			List<Item_Brand> list = new ArrayList<>();
		item_brandRepository.findAll().forEach(e -> list.add(e));
			return list;
	}

	@Override
	public Item_Brand find(int id) {
		//return companyRepository.findOne(id);
		return null;
	}




}
