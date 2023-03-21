package com.min.simplesns.configuration.filter;

import com.min.simplesns.util.JwtTokenUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Filter;

@Slf4j
@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final String key;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // get header
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(header == null || !header.startsWith("Bearer ")){
            log.error("Error occurs while getting header, header is null or invalid");
            filterChain.doFilter(request, response);
            return;
        }

        try{
            final String token = header.split(" ")[1].trim();
            // TODO : check token is valid
            if(JwtTokenUtils.isExpired(token, key)){
                log.error("Key is expired");
            }
            // TODO : get userName from token
            String userName = "";
            // TODO : check the userName is valid

            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    // TODO
                    null, null, null
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (RuntimeException e){
            log.error("Error occurs while validating. {}", e.toString());
            filterChain.doFilter(request, response);
            return;
        }

        filterChain.doFilter(request, response);
    }
}
