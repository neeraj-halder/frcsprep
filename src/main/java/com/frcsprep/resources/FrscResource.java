package com.frcsprep.resources;

import com.frcsprep.entity.AnswerOptions;
import com.frcsprep.entity.Questions;
import com.frcsprep.entity.Topics;
import com.frcsprep.pojo.QuestionRequest;
import com.frcsprep.pojo.TopicsRequest;
import com.frcsprep.repo.AnswerRequest;
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

    @RequestMapping(value = "/question", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Questions> insertQuestion(@RequestBody QuestionRequest qr){
        Questions questions = questionServices.insertQuestion(qr);
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

    @RequestMapping(value = "/answers", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AnswerOptions>> getAnswerOptions(){
        List<AnswerOptions> answerOptionslist = answerServices.getAllAnswerOptions();
        return new ResponseEntity<List<AnswerOptions>>(answerOptionslist, HttpStatus.OK);
    }

    @RequestMapping(value = "/answers", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AnswerOptions>> insertAnswers(@RequestBody AnswerRequest answers){
        List<AnswerOptions> answerOptionslist = answerServices.insertAnswers(answers);
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

    @RequestMapping(value = "/topics", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Topics>> getAllTopics(){
        List<Topics> topics = topicServices.getAllTopics();
        return new ResponseEntity<List<Topics>>(topics, HttpStatus.OK);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Topics>> insertTopics(@RequestBody TopicsRequest topics){
            List<Topics> insertedTopics = topicServices.insertTopics(topics);
        return new ResponseEntity<List<Topics>>(insertedTopics, HttpStatus.OK);
    }

}
