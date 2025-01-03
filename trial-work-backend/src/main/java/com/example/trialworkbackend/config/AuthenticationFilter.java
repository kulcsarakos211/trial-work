package com.example.trialworkbackend.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.io.PrintWriter;

public class AuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            Authentication auth = AuthenticationService.getAuthentication((HttpServletRequest) request);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        catch (Exception e) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
            PrintWriter printWriter = httpResponse.getWriter();
            printWriter.print(e.getMessage());
            printWriter.flush();
            printWriter.close();
        }

        chain.doFilter(request, response);
    }
}
