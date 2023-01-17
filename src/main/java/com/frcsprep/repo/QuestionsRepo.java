package com.frcsprep.repo;

import com.frcsprep.entity.Questions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepo extends CrudRepository<com.frcsprep.entity.Questions, Integer> {
    Questions findByQuestion(String q);
}
