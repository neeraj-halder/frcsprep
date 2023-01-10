package com.frcsprep.services;

import com.frcsprep.entity.AnswerOptions;
import com.frcsprep.repo.AnswerOptionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnswerServices {

    @Autowired
    private AnswerOptionsRepo answerOptionsRepo;

    public List<AnswerOptions> getAnswerOptionsByIds(List<String> answerOptionIds){
        List<Long> listofLong = answerOptionIds.stream().map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        List<AnswerOptions> listOfAnswerOptions = answerOptionsRepo.findByAnswerOptionIdIn(listofLong);
        return  listOfAnswerOptions;
    }

    public AnswerOptions getAnswerOption(Integer answerOptionId){
        Optional<AnswerOptions> answerOptionsOpt = answerOptionsRepo.findById(answerOptionId);
        if(answerOptionsOpt.isPresent()){
            return  answerOptionsOpt.get();
        }
        return null;
    }

    public List<AnswerOptions> getAnswerOptionByIds(List<Long> answerOptionIds){
        List<AnswerOptions> answerOptionsList = answerOptionsRepo.findByAnswerOptionIdIn(answerOptionIds);
        return answerOptionsList;
    }

}
