package com.tranphucvinh.jpa.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tranphucvinh.jpa.model.Work;

@Repository
@Transactional
public interface WorkRepository extends JpaRepository<Work, Long> {
	
}