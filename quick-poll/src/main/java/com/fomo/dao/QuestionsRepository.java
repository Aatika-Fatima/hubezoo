package com.fomo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fomo.model.Question;

@Repository
public interface QuestionsRepository extends JpaRepository<Question,Long>{
	
}
