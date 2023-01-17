package com.frcsprep.services;

import com.frcsprep.entity.Topics;
import com.frcsprep.pojo.TopicsRequest;
import com.frcsprep.repo.TopicsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Topics> getAllTopics(){
        List<Topics> topics = (List<Topics>) topicsRepo.findAll();
        return topics;
    }

    public List<Topics> insertTopics(TopicsRequest topics){

       List<Topics> list =  topics.getTopics().stream().filter(k->{
            Topics topic = topicsRepo.findByTopic(k);
            if(topic != null && topic.getTopic() != null){
                return false;
            }
            return true;
        }).map(n->{
                Topics t = new Topics();
                t.setTopic(n);
                Topics savedT = topicsRepo.save(t);
                return savedT;
        }).collect(Collectors.toList());

        return list;
    }
}
