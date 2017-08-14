package com.fomo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fomo.model.Interest;

@Repository
public interface InterestRepostiory extends JpaRepository<Interest, Long>{

}
