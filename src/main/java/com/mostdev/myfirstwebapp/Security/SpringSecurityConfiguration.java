package com.mostdev.myfirstwebapp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

   // InMemoryUserDetailsManager
    //InMemoryUserDetailsManager(UserDetails... users)


   @Bean
   InMemoryUserDetailsManager createUserDetailsManager() {

       Function<String, String> passwordEncoder
               = input -> passwordEncoder().encode(input);

       UserDetails userDetails = User.builder()
               .passwordEncoder(passwordEncoder)
                .username("Elijah")
                .password("panther")
                .roles("USER", "ADMIN")
                .build();

                return new InMemoryUserDetailsManager(userDetails);
   }

   @Bean
    PasswordEncoder passwordEncoder() {
       // uses Bcrypt hashing function
       return new BCryptPasswordEncoder();
   }
}
