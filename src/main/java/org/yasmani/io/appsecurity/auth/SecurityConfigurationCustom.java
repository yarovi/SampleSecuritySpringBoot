package org.yasmani.io.appsecurity.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfigurationCustom {

    Logger logger = LoggerFactory.getLogger(SecurityConfigurationCustom.class);

    @Bean
    public SecurityFilterChain securityContextHolder(HttpSecurity http) throws Exception {

        logger.info("Configuring SecurityFilterChain");
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/auth/**").permitAll()
                                .anyRequest().authenticated()
                ).
         httpBasic(Customizer.withDefaults())
        .formLogin(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user= User.builder()
                .password(
                        passwordEncoder().
                                encode("123"))
                .username("yami")
                .roles("USER")
                .build();

        user.getAuthorities().forEach(authority ->
                logger.info("Authority assigned: " + authority.getAuthority())
        );
        return new InMemoryUserDetailsManager(user);

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
