package com.edsolabs.CVEdso.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsolabs.CVEdso.entity.HistoryEntity;
import com.edsolabs.CVEdso.repository.HistoryRepository;

@Service
public class HistoryService {
	
	@Autowired
	private HistoryRepository historyRepository;
	
	public List<HistoryEntity> getAllHistory(){
		return (List<HistoryEntity>) historyRepository.findAll();
	}
	
	public void saveCv(HistoryEntity history) {
		historyRepository.save(history);
	}
}
