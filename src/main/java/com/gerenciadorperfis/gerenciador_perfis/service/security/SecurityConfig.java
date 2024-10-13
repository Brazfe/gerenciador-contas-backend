package com.gerenciadorperfis.gerenciador_perfis.service.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gerenciadorperfis.gerenciador_perfis.model.Usuario;
import com.gerenciadorperfis.gerenciador_perfis.service.UsuarioService;

@EnableWebSecurity
public class SecurityConfig {

	
    @Autowired
    private UsuarioService usuarioService;
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .cors().and() 
            .authorizeRequests()
            .antMatchers("/h2-console/**").permitAll()
            .antMatchers("/h2-console/**").permitAll()
            .antMatchers("/api/perfis/**").permitAll()  
            .antMatchers("/api/usuarios/**").permitAll()
            .antMatchers("/api/security/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .httpBasic();

        http.headers().frameOptions().sameOrigin();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            if ("admin".equals(username)) {
                return User.withUsername("admin")
                           .password(passwordEncoder().encode("admin")) 
                           .roles("USER") 
                           .build();
            }

            Usuario usuario = usuarioService.buscaUsuarioPorLogin(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));


            return User.withUsername(usuario.getUsuario())
                    	.password(passwordEncoder().encode(usuario.getSenha())) 
                       .roles("USER")  
                       .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
