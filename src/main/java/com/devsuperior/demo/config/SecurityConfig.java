package com.devsuperior.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//A classe de configuração é uma classe onde posso definir componentes(@Bean) na forma de métodos.
@Configuration
public class SecurityConfig {

    //É um componente que pode ser injetado em vários lugares. Serve para criar um hash na senha.
    //PasswordEncoder é a interface e posso trocá-la. O new BCryptPasswordEncoder é a implementação.
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //SecurityFilterChain não é o tipo de um método da nossa entidade, por isso usamos o @Bean aqui.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return http.build();
    }
}
