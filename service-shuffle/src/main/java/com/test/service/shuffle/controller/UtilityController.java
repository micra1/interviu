package com.test.service.shuffle.controller;

import com.test.service.shuffle.dto.LogRequest;
import com.test.service.shuffle.service.IShuffleService;
import com.test.service.shuffle.service.KafkaMessagePublisher;
import com.test.service.shuffle.util.LogRequestBuilder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(path = "/utility", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@RequiredArgsConstructor
public class UtilityController {
    private final IShuffleService shuffleService;
    private final KafkaMessagePublisher kafkaMessagePublisher;
    private final LogRequestBuilder logRequestBuilder;


    @PostMapping("/shuffle")
    public List<Integer> shuffle(@RequestBody @Min(1) @Max(1000) Integer number, HttpServletRequest request) {
        kafkaMessagePublisher.publish("logs.http.requests", logRequestBuilder.build(request, number));
        return shuffleService.shuffle(number);
    }
}
