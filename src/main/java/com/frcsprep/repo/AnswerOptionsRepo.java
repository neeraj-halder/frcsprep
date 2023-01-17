package com.frcsprep.repo;

import com.frcsprep.entity.AnswerOptions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerOptionsRepo extends CrudRepository<AnswerOptions, Integer> {
    List<AnswerOptions> findByAnswerOptionIdIn(List<Long> answerOptionIds);
    AnswerOptions findByAnswer(String answer);
}
