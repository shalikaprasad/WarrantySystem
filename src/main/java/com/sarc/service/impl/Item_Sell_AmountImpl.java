package com.sarc.service.impl;

import com.sarc.bean.Item_Sell_Amount;
import com.sarc.repository.Item_Sell_AmountRepository;
import com.sarc.service.Item_Sell_AmountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class Item_Sell_AmountImpl implements Item_Sell_AmountService {

	@Autowired
	private Item_Sell_AmountRepository item_sell_amountRepository;

	@Override
	public Item_Sell_Amount save(Item_Sell_Amount entity) {
		return item_sell_amountRepository.save(entity);
	}

	@Override
	public Item_Sell_Amount update(Item_Sell_Amount entity) {
		return item_sell_amountRepository.save(entity);
	}

	@Override
	public void delete(Item_Sell_Amount entity) {
		item_sell_amountRepository.delete(entity);
	}

	@Override
	public void deleteInBatch(List<Item_Sell_Amount> item_sell_amounts) {
		item_sell_amountRepository.deleteInBatch(item_sell_amounts);
	}

	@Override
	public List<Item_Sell_Amount> findAll() {
			List<Item_Sell_Amount> list = new ArrayList<>();
		item_sell_amountRepository.findAll().forEach(e -> list.add(e));
			return list;
	}

	@Override
	public Item_Sell_Amount find(int id) {
		//return companyRepository.findOne(id);
		return null;
	}




}
