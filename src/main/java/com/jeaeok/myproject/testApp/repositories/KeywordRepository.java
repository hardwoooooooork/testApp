package com.jeaeok.myproject.testApp.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jeaeok.myproject.testApp.domain.Keyword;
import com.jeaeok.myproject.testApp.domain.User;


public interface KeywordRepository extends CrudRepository<Keyword, Long> {
	List<Keyword> findByUser(User user);
}
