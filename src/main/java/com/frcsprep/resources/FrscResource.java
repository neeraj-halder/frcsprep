package com.frcsprep.resources;

import com.frcsprep.entity.AnswerOptions;
import com.frcsprep.entity.Questions;
import com.frcsprep.entity.Topics;
import com.frcsprep.pojo.TopicsRequest;
import com.frcsprep.services.AnswerServices;
import com.frcsprep.services.QuestionServices;
import com.frcsprep.services.TopicServices;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frscprep")
public class FrscResource {

    @Autowired
    private QuestionServices questionServices;

    @Autowired
    private AnswerServices answerServices;

    @Autowired
    private TopicServices topicServices;

    @RequestMapping(value = "/questions/{questionId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Questions> getQuestion(
            @PathVariable("questionId")
            @Size(max = 2, message = "should be max 2 character") Integer questionId){
        Questions questions = questionServices.getQuestionsById(questionId);
        return new ResponseEntity<Questions>(questions, HttpStatus.OK);
    }

    @RequestMapping(value = "/answer/{answerOptionId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AnswerOptions> getAnswerOption(
            @PathVariable("answerOptionId")
            @Size(max = 2, message = "should be max 2 character") Integer answerOptionId){
        AnswerOptions answerOptions = answerServices.getAnswerOption(answerOptionId);
        return new ResponseEntity<AnswerOptions>(answerOptions, HttpStatus.OK);
    }

    @RequestMapping(value = "/answers/{answerOptionIds}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AnswerOptions>> getAnswerOption(
            @PathVariable("answerOptionIds")
            @Size(max = 2, message = "should be max 2 character") List<String> answerOptionIds){
        List<AnswerOptions> answerOptionslist = answerServices.getAnswerOptionsByIds(answerOptionIds);
        return new ResponseEntity<List<AnswerOptions>>(answerOptionslist, HttpStatus.OK);
    }

    @RequestMapping(value = "/topic/{topicId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Topics> getTopic(
            @PathVariable("topicId")
            @Size(max = 2, message = "should be max 2 character") Integer topicId){
        Topics topics = topicServices.getTopicById(Long.valueOf(topicId));
        return new ResponseEntity<Topics>(topics, HttpStatus.OK);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Topics>> insertTopics(@RequestBody TopicsRequest topics){
            List<Topics> insertedTopics = topicServices.insertTopics(topics);
        return new ResponseEntity<List<Topics>>(insertedTopics, HttpStatus.OK);
    }

}
