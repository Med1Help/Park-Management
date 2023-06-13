package com.ParkManagement.ParkManagement.config;

import com.ParkManagement.ParkManagement.models.User;
import com.ParkManagement.ParkManagement.service.JwtService;
import com.ParkManagement.ParkManagement.service.users_service;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    JwtService jwtService;
    @Autowired
    @Lazy
    users_service usersService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String token;
        final String e_mail;
        if(authHeader == null || !authHeader.startsWith("Bearer")){
            filterChain.doFilter(request,response);
            return;
        }
        token = authHeader.substring(7);
        e_mail = jwtService.extUseremail(token);
        if(e_mail != null && SecurityContextHolder.getContext().getAuthentication() == null ){
            User user = usersService.selectUsers("e_mail" , new Object[]{e_mail});
            if(jwtService.isTokenValid(token,user)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken( user,null,user.getAuthorities());
                authToken.setDetails( new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
