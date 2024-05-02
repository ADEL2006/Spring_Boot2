package kr.hs.dge.dgsw.ex1.jwt.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.hs.dge.dgsw.ex1.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // jwt 인증
        // headers
        // Authorization(key): Bearer eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJ1c2VyMUBhYWEuY29tIiwiaWF0IjoxNzE0NTM5NzkwLCJleHAiOjE3MTQ1NDA2OTB9.hbaBMkXVzjFEg4U-byj52nBRr1l0K3euxP9LSGDW5RyIRSgT3uZ_oGtHypnUT2J3

        String jwtToken = null;
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(StringUtils.hasText(authorization) && authorization.startsWith("Bearer")){
            jwtToken = authorization.substring(7);
        }
        if (jwtToken != null) {
            // Authentication 객체
            SecurityContextHolder.getContext().setAuthentication(jwtUtil.getAuthentication(jwtToken));
        }
        filterChain.doFilter(request, response);
    }
}
