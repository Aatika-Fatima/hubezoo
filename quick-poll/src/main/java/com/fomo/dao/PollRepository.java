package com.fomo.dao;

import org.springframework.data.repository.CrudRepository;

import com.fomo.model.Poll;

public interface PollRepository extends CrudRepository<Poll, Long>{

}
