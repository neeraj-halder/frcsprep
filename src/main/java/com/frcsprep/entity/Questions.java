package com.frcsprep.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "QUESTIONS")
@Data
@Setter
@Getter
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QUESTION_ID", unique = true, nullable = false)
    private long questionId;

    @Column(name = "TOPIC_ID", nullable = false)
    private Integer topicId;

    @Column(name = "QUESTION", nullable = false)
    private String question;

    @Column(name = "ANSWER_OPTIONS", nullable = false)
    private String answerOptions;

    @Column(name = "CORRECT_ANSWER", nullable = false)
    private String correctAnswer;

}
