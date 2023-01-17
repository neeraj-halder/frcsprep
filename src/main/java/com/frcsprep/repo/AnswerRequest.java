package com.frcsprep.repo;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequest {

    private List<String> answers;

}
