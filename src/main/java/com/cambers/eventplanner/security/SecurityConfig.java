package com.cambers.eventplanner.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
/*
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/css/**","/images/**","/js/**","/common/**").permitAll() // Rutas públicas
                                .requestMatchers("/admin/**").hasRole("ADMIN") // Rutas para administradores
                                .requestMatchers("/planner/**").hasRole("PLANNER") // Rutas para planners registrados
                                .requestMatchers("/host/**").hasRole("HOST") // Rutas para usuarios registrados
                                .anyRequest().authenticated()
                )
                .formLogin(formLogin-> formLogin.loginPage("/login").defaultSuccessUrl("/"))
                .logout(logout->logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login"));
        return http.build();
    }

 */
}