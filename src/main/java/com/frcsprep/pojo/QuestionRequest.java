package com.frcsprep.pojo;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {

    private Integer topicId;
    private String question;
    private String answerOptions;
    private Integer correctAnswer;

}
