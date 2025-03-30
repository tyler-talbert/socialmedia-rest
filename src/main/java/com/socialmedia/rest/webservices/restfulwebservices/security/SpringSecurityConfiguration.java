package com.socialmedia.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 1) All requests authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        // 2) If a request is not authenticated, show the login popup
        http.httpBasic(withDefaults());

        // 3) CSRF -> POST, PUT
        http.csrf(csrf -> csrf
                .ignoringRequestMatchers("/jpa/**") // Disable CSRF for /jpa endpoints
                .requireCsrfProtectionMatcher(request -> {
                    // Disable CSRF for POST and PUT methods
                    return !("POST".equals(request.getMethod()) || "PUT".equals(request.getMethod()));
                })
        );
        return http.build();
    }
}
