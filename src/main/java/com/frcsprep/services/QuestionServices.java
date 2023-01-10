package com.frcsprep.services;

import com.frcsprep.entity.AnswerOptions;
import com.frcsprep.entity.Questions;
import com.frcsprep.repo.QuestionsRepo;
import com.frcsprep.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServices {

    @Autowired
    private QuestionsRepo questionsRepo;

    @Autowired
    private CommonUtils commonUtils;

    @Autowired
    private AnswerServices answerServices;

    public Questions getQuestionsById(Integer questionId){
        Optional<Questions> optQuestions = questionsRepo.findById(questionId);
        if(optQuestions.isPresent()){
            Questions questions =  optQuestions.get();
//            String answerOptions = questions.getAnswerOptions();
//            List<Long> integerList = commonUtils.convertCommaSeparatedStringToList(answerOptions);
//            List<AnswerOptions> listOfAnswerOptions = answerServices.getAnswerOptionsByIds(integerList);
            return  optQuestions.get();

        }
        return null;
    }
}
