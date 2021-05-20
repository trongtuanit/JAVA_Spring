package com.hit.services;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hit.utils.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private MyUserDetailsService myUserDetailService;

	private final String HEADER_KEY = "Authorization";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {

			String authorization = request.getHeader(HEADER_KEY);
			String jwt = null;
			String username = null;
			if (authorization.startsWith("Bearer ") && authorization != null) {
				jwt = authorization.substring(7);
				// subString(7) because Bearer has 7 letters
				// jwt is a sub string which is sent by header after "Bearer"
				username = jwtUtil.extractUsername(jwt);
				// 
			}
			if (username != null) {
				UserDetails userDetails = myUserDetailService.loadUserByUsername(username);
				if (jwtUtil.validateToken(jwt, userDetails)) {
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		filterChain.doFilter(request, response);
	}

}
