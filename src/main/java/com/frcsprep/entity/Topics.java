package com.frcsprep.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TOPICS")
@Data
@Setter
@Getter
public class Topics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOPIC_ID", unique = true, nullable = false)
    private long topicId;

    @Column(name = "TOPIC", nullable = false)
    private String topic;
}
