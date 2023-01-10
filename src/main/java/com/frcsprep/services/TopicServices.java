package com.frcsprep.services;

import com.frcsprep.entity.Topics;
import com.frcsprep.repo.TopicsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicServices {

    @Autowired
    TopicsRepo topicsRepo;

    public Topics getTopicById(Long topicId){
        Optional<Topics> topicsOptional = topicsRepo.findById(topicId);
        if(topicsOptional.isPresent()){
            return topicsOptional.get();
        }
        return null;
    }
}
