package org.as2;

import org.springframework.beans.factory.annotation.Value;
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
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class JwtSecurityConfiguration {

    @Value("${okta.oauth2.issuer}")
    private String issuer;
    @Value("${okta.oauth2.client-id}")
    private String clientId;

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
        http.csrf((csrf) -> csrf.disable()).cors(withDefaults())
                .authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests.anyRequest().permitAll());
//        http.csrf(AbstractHttpConfigurer::disable) //(csrf) -> csrf.disable()
//                .cors(withDefaults())
//                .sessionManagement((sessionManagement) -> sessionManagement.
//                        sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                // commented code will allow POST requests to /login without authentication and rest of the requests will be authenticated
//                .authorizeHttpRequests((authorizeHttpRequests) ->
//                        authorizeHttpRequests.requestMatchers(HttpMethod.POST,
//                                "/login").permitAll().anyRequest().authenticated())
                //Role based auth : The
                ///admin/** endpoint requires the ADMIN role for access and the /user/** endpoint requires the
                //USER role for access
//                .authorizeHttpRequests((authorizeHttpRequests) ->
//                        authorizeHttpRequests
//
//                                .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
//                                .requestMatchers(HttpMethod.POST, "/login").permitAll()
//                                .requestMatchers("/admin/**").hasRole("ADMIN")
//                                .requestMatchers("/data-rest/user/**").hasRole("USER")
//                                .anyRequest().authenticated())
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/", "/images/**").permitAll()
//                        .anyRequest().authenticated()
//                )
 //               .oauth2Login(withDefaults())
//                .addFilterBefore(authenticationFilter,
//                UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling((exceptionHandling) -> exceptionHandling.
//                        authenticationEntryPoint(exceptionHandler))
//                .logout(logout -> logout
//                        .addLogoutHandler(logoutHandler()));
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

    private LogoutHandler logoutHandler() {
        return (request, response, authentication) -> {
            try {
                String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
                response.sendRedirect(issuer + "v2/logout?client_id=" + clientId + "&returnTo=" + baseUrl);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}


//TODO: explore @PreAuthorize, @PostAuthorize, @PreFilter, @PostFilter, and
//@Secured annotations, which are used to apply method-level security