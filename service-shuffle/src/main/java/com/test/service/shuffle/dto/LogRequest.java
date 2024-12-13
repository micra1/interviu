package com.test.service.shuffle.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogRequest {
    private String path;
    private String method;
    private Map<String, String> headers;
    private Object body;
    private String timestamp;
}