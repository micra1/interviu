package com.test.service.shuffle.util;

import com.test.service.shuffle.dto.LogRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class LogRequestBuilder {

    public LogRequest build(HttpServletRequest request, Object body) {
        return new LogRequest(
                request.getRequestURI(),
                request.getMethod(),
                extractHeaders(request),
                body,
                String.valueOf(System.currentTimeMillis())

        );
    }

    private Map<String, String> extractHeaders(HttpServletRequest request) {
        return Collections.list(request.getHeaderNames()).stream()
                .collect(Collectors.toMap(
                        headerName -> headerName,
                        request::getHeader
                ));
    }
}
