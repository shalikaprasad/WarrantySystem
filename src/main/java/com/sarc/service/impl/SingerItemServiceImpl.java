package com.sarc.service.impl;

import com.sarc.bean.SingerItems;
import com.sarc.repository.SingerItemRepository;
import com.sarc.service.SingerItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SingerItemServiceImpl implements SingerItemService {

	@Autowired
	private SingerItemRepository singerItemRepository;

	@Override
	public SingerItems findBySerialNumber(String serialNumber) {
		return singerItemRepository.findBySerialNumber(serialNumber);
	}

	@Override
	public SingerItems save(SingerItems entity) {
		return singerItemRepository.save(entity);
	}

	@Override
	public SingerItems update(SingerItems entity) {
		return singerItemRepository.save(entity);
	}

	@Override
	public void delete(SingerItems entity) {
		singerItemRepository.delete(entity);
	}

	@Override
	public void deleteInBatch(List<SingerItems> singerItems) {
		singerItemRepository.deleteInBatch(singerItems);
	}

	@Override
	public List<SingerItems> findAll() {
			List<SingerItems> list = new ArrayList<>();
			singerItemRepository.findAll().forEach(e -> list.add(e));
			return list;
	}

	@Override
	public SingerItems find(int id) {
		//return companyRepository.findOne(id);
		return null;
	}




}
