package com.morg4n.morg4n_users.security.configuration;

import com.morg4n.morg4n_users.security.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Julian David Camacho Erazo (Morg4n) {@literal <jdacamachoe@gmail.com>}
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfigurations {
    private final JwtAuthenticationFilter jwtFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(authRequest -> authRequest
                .requestMatchers("/api/auth/").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/users/**").hasAnyRole("Admin", "User")
                .requestMatchers(HttpMethod.POST, "/api/users/**").hasRole("Admin")
                .requestMatchers(HttpMethod.PUT, "/api/users/**").hasRole("Admin")
                .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("Admin")
                .requestMatchers(HttpMethod.PATCH, "/api/users/**").hasRole("Admin")
                .anyRequest().permitAll()
            )
            .sessionManagement(sessionManager -> sessionManager
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
    }
}
