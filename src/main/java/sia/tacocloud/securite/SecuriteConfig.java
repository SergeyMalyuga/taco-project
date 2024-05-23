package sia.tacocloud.securite;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import sia.tacocloud.entyties.UserM;
import sia.tacocloud.repositories.UserRepository;

@Configuration
@EnableWebSecurity
public class SecuriteConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            UserM user = userRepo.findByUsername(username);
            if (user != null) {
                return user;
            } else {
                throw new UsernameNotFoundException("User ‘" + username + "’ not found");
            }
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSessionRequestCache requestCache = new HttpSessionRequestCache();
        requestCache.setMatchingRequestParameterName("continue");
        http.requestCache((cache) -> cache
                .requestCache(requestCache)
        );
        return http.authorizeHttpRequests(request -> request
                        .requestMatchers("/design/**", "orders/**").authenticated()
                        .anyRequest().permitAll())
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .defaultSuccessUrl("/home")
                                .permitAll()
                ).logout(l -> l.logoutUrl("/logout").permitAll()).headers(headers -> headers.frameOptions().disable())
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")).build();
    }
}
