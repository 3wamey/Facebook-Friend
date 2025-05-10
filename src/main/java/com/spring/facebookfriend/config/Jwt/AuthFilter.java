package com.spring.facebookfriend.config.Jwt;


import com.spring.facebookfriend.model.jwt.Roles;
import com.spring.facebookfriend.model.jwt.Users;
import com.spring.facebookfriend.service.Jwt.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenHandler tokenHandler;

    // Skip filtering for login/register
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return path.contains("login") || path.contains("register");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader("Authorization");

        if (token == null || !token.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid Authorization header.");
            return;
        }

        token = token.substring(7); // Strip "Bearer "

        if (!tokenHandler.validateToken(token)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token.");
            return;
        }

        Users user;
        try {
            user = userService.checkUserExistByToken(token);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Token parsing failed.");
            return;
        }

        if (user == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not found.");
            return;
        }

        // Set user authentication in Spring Security context
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(user, null, getAuthorities(user.getRoles()));

        SecurityContextHolder.getContext().setAuthentication(authToken);

        // Continue to next filter
        filterChain.doFilter(request, response);
    }

    private List<GrantedAuthority> getAuthorities(List<Roles> rolesList) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Roles role : rolesList) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
        return authorities;
    }
}
