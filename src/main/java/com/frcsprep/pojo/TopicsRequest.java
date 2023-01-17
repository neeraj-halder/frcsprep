package com.frcsprep.pojo;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopicsRequest {

    private List<String> topics;

}
