package com.edsolabs.CVEdso.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edsolabs.CVEdso.entity.CvEntity;
import com.edsolabs.CVEdso.repository.CvRepository;
import com.edsolabs.CVEdso.service.ICvService;

@Service
public class CvService implements ICvService {
	
	@Autowired
	private CvRepository cvRepository;
	
	public List<CvEntity> getAllCv(){
		return (List<CvEntity>) cvRepository.findAll();
	}
	
	public void saveCv(CvEntity cv) {
		cvRepository.save(cv);
	}
	
	public Optional<CvEntity> findCvById(Long id){
		return cvRepository.findById(id);
	}
	
	public void deleteCv(Long id) {
		cvRepository.deleteById(id);
	}
}
