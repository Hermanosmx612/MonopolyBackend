package edu.proyecto.monopoly.proyecto_monopoly.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import edu.proyecto.monopoly.proyecto_monopoly.filters.JwtAuthenticationFilter;
import edu.proyecto.monopoly.proyecto_monopoly.srv.impl.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){ // Permite cifrar la contraseña
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

    private static final String[] WHITE_LIST_URL = {
        "/api-docs/**",
        "/swagger-ui/**",
        "/webjars",
        "/auth/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //Permitir no estar autenticado /aith y el resto obligar a autentificar
        //Comprobar el token en cada peticion
        http
          .cors(customizer -> customizer.configurationSource(CorsConfigurationSource()))
          .csrf(csrf -> csrf
                    .disable())
          .authorizeHttpRequests(authRequest -> authRequest
                .requestMatchers(WHITE_LIST_URL).permitAll()
                .anyRequest().authenticated())
          .sessionManagement(sessionManager -> sessionManager
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
          .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
          return http.build();
    }

    //CORS Mecanismo que poermite recursos con acceso restringido puedan ser utilizados desde fuera de la API,
    // por ejemplo desde Angular

    @Bean
    CorsConfigurationSource CorsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        //Configurar desde donde se puede invocar a la API
        configuration.setAllowedOrigins(List.of("http://localhost:8005", "http://localhost:4200"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    
    
}
