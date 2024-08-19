package org.as2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class JwtSecurityConfiguration {

    private final AuthenticationFilter authenticationFilter;
    private final AuthEntryPoint exceptionHandler;

    public JwtSecurityConfiguration(AuthenticationFilter authenticationFilter, AuthEntryPoint exceptionHandler) {
        this.authenticationFilter = authenticationFilter;
        this.exceptionHandler = exceptionHandler;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws
            Exception {
        http.csrf(AbstractHttpConfigurer::disable) //(csrf) -> csrf.disable()
                .cors(Customizer.withDefaults())
                .sessionManagement((sessionManagement) -> sessionManagement.
                        sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // commented code will allow POST requests to /login without authentication and rest of the requests will be authenticated
//                .authorizeHttpRequests((authorizeHttpRequests) ->
//                        authorizeHttpRequests.requestMatchers(HttpMethod.POST,
//                                "/login").permitAll().anyRequest().authenticated())
                //Role based auth : The
                ///admin/** endpoint requires the ADMIN role for access and the /user/** endpoint requires the
                //USER role for access
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests

                                .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/data-rest/user/**").hasRole("USER")
                                .anyRequest().authenticated())
                .addFilterBefore(authenticationFilter,
                UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling((exceptionHandling) -> exceptionHandling.
                        authenticationEntryPoint(exceptionHandler));
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // localhost:3000 is allowed
        // config.setAllowedOrigins(Arrays.asList ("http://localhost:3000"));
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowCredentials(false);
        config.applyPermitDefaultValues();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}


//TODO: explore @PreAuthorize, @PostAuthorize, @PreFilter, @PostFilter, and
//@Secured annotations, which are used to apply method-level security