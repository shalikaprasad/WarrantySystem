package com.sarc.service.impl;

import com.sarc.bean.Item;
import com.sarc.repository.ItemRepository;
import com.sarc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item save(Item entity) {
		return itemRepository.save(entity);
	}

	@Override
	public Item update(Item entity) {
		return itemRepository.save(entity);
	}

	@Override
	public void delete(Item entity) {
		itemRepository.delete(entity);
	}

	@Override
	public void deleteInBatch(List<Item> items) {
		itemRepository.deleteInBatch(items);
	}

	@Override
	public List<Item> findAll() {
			List<Item> list = new ArrayList<>();
		itemRepository.findAll().forEach(e -> list.add(e));
			return list;
	}

	@Override
	public Item find(int id) {
		//return companyRepository.findOne(id);
		return null;
	}




}
