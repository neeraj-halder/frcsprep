package com.frcsprep.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ANSWER_OPTIONS")
@Data
@Setter
@Getter
public class AnswerOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANSWER_OPTION_ID", unique = true, nullable = false)
    private long answerOptionId;

    @Column(name = "ANSWER", nullable = false)
    private String answer;

}
