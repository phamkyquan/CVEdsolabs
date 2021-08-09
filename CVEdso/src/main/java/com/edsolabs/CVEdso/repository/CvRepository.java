package com.edsolabs.CVEdso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edsolabs.CVEdso.entity.CvEntity;

@Repository
public interface CvRepository extends JpaRepository<CvEntity, Long> {
}
