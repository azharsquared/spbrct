package org.as2;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// @Configuration annotation indicates that a class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.
// @EnableWebSecurity annotation is used to enable Spring Security web security in the application.
// uncomment the following line to enable in memory user .
//@Configuration
//@EnableWebSecurity
public class InMemorySecurityConfig {

    // @Bean annotation tells Spring that a method annotated with @Bean will return an object that should be registered as a bean in the Spring application context.
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder().username("user").
                password(passwordEncoder().encode("password"))
                .roles("USER").build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // TODO: Learn more about BCryptPasswordEncoder
        /**
         * $2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW
         $2a represents the algorithm version, and $10 represents the strength of the
         algorithm. The default strength of Spring Security’s BcryptPasswordEncoder
         class is 10. bcrypt generates a random salt in hashing, so the hashed result
         is always different
         *
         * */
        return new BCryptPasswordEncoder();
    }

}
