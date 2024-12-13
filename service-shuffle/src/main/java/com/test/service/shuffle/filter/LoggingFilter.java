package com.test.service.shuffle.filter;

import com.test.service.shuffle.dto.LogRequest;
import com.test.service.shuffle.service.MessagePublisher;
import com.test.service.shuffle.util.LogRequestBuilder;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;

import java.io.IOException;

@Component
@WebFilter("/*")
@Slf4j
@RequiredArgsConstructor
public class LoggingFilter implements Filter {
    private final LogRequestBuilder logRequestBuilder;
    private final MessagePublisher messagePublisher;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);

        chain.doFilter(request, response);

//        LogRequest logRequest = logRequestBuilder.build(wrappedRequest);
//        messagePublisher.publish("logs.http.requests", logRequest);
//        log.info("LogRequest: {}", logRequest);
    }
}