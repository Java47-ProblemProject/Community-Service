package telran.community.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(ex -> ex.authenticationEntryPoint(new CustomAuthenticationEntryPoint()));
        http.cors(Customizer.withDefaults());
        http.sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests(authorize -> authorize
                        .requestMatchers("/community/getcommunitiesnames")
                        .permitAll()
                        .requestMatchers("/community/getcommunities", "community/getcommunities/*")
                        .authenticated()
//                       //Administrative section//
                        .requestMatchers(HttpMethod.POST, "/community/addcommunity")
                        .access("hasAuthority('ADMINISTRATOR')")
                        .requestMatchers(HttpMethod.PUT, "/community/editname/**")
                        .access("hasAuthority('ADMINISTRATOR')")
                        .requestMatchers(HttpMethod.PUT, "/community/editdescription/**")
                        .access("hasAuthority('ADMINISTRATOR')")
                        .requestMatchers(HttpMethod.DELETE, "/community/deletecommunity/{communityId}")
                        .access("hasAuthority('ADMINISTRATOR')")
                        .anyRequest()
                        .authenticated()
        );
        return http.build();
    }
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://127.0.0.1:5173/", "http://127.0.0.1:5173"));
        configuration.setAllowedMethods(List.of("POST", "PUT", "GET", "OPTIONS", "DELETE", "PATCH"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
