package com.frcsprep.services;

import com.frcsprep.entity.AnswerOptions;
import com.frcsprep.entity.Topics;
import com.frcsprep.repo.AnswerOptionsRepo;
import com.frcsprep.repo.AnswerRequest;
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

    public List<AnswerOptions> insertAnswers(AnswerRequest answers){

        List<AnswerOptions> list =  answers.getAnswers().stream().filter(k->{
            AnswerOptions answerOptions = answerOptionsRepo.findByAnswer(k);
            if(answerOptions != null && answerOptions.getAnswer() != null){
                return false;
            }
            return true;
        }).map(n->{
            AnswerOptions ao = new AnswerOptions();
            ao.setAnswer(n);
            AnswerOptions savedAo = answerOptionsRepo.save(ao);
            return savedAo;
        }).collect(Collectors.toList());

        return list;

    }
    public List<AnswerOptions> getAnswerOptionByIds(List<Long> answerOptionIds){
        List<AnswerOptions> answerOptionsList = answerOptionsRepo.findByAnswerOptionIdIn(answerOptionIds);
        return answerOptionsList;
    }

}
