package edu.famous.E_Commerce_Product_Search.common.core.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        long startTime = System.currentTimeMillis();

        try {
            // Log request details
            logger.info("[REQUEST] {} {} from IP: {}",
                    request.getMethod(),
                    request.getRequestURI(),
                    request.getRemoteAddr());

            // Continue the filter chain
            filterChain.doFilter(request, response);

        } finally {
            // Log response after processing
            long duration = System.currentTimeMillis() - startTime;
            logger.info("[RESPONSE] {} {} -> {} ({} ms)",
                    request.getMethod(),
                    request.getRequestURI(),
                    response.getStatus(),
                    duration);
        }
    }
}
