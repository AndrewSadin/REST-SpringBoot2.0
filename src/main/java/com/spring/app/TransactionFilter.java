package com.spring.app;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class TransactionFilter implements Filter {
    private final static Logger logger = LoggerFactory.getLogger(TransactionFilter.class);

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
        logger.info("Initializing filter :{}", this);
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        logger.info("Starting Transaction for req :{}", req.getRequestURI());
        logger.info("Starting Transaction from IP :{}", req.getRemoteAddr());
        chain.doFilter(request, response);
        StringBuilder inputStringBuilder = new StringBuilder();
        logger.info("Committing Transaction for req :{}", req.getRequestURI());
    }

    @Override
    public void destroy() {
        logger.warn("Destructing filter :{}", this);
    }
}
