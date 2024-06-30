package ru.bazunaka.bazbloglite.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Этот код является конфигурационным классом для Spring Security.
 * Он определяет правила безопасности и настройки аутентификации.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    /**
     * Создает цепочку фильтров безопасности для HTTP-запросов.
     *
     * @param http объект HttpSecurity для настройки правил безопасности
     * @return цепочка фильтров безопасности
     * @throws Exception если возникла ошибка при настройке
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        /**
         * Создает экземпляр PasswordEncoder для хеширования паролей пользователей.
         *
         * @return экземпляр PasswordEncoder
         */
        /*
         * authorizeHttpRequests - определяет правила авторизации для различных URL-адресов.
         * В данном случае, /api/v1/accounts/register доступен для всех, /error доступен для всех,
         * /api/v1/demo/just-role-user доступен только для пользователей с ролью "USER",
         * /api/v1/demo/just-role-admin доступен только для пользователей с ролью "ADMIN",
         * а все остальные URL-адреса требуют аутентификации.
         */
        http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/accounts/register").permitAll()
                        .requestMatchers("/error").permitAll()
                        .requestMatchers("/api/v1/demo/just-role-user").hasRole("USER")
                        .requestMatchers("/api/v1/demo/just-role-admin").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        /*
        Создает экземпляр PasswordEncoder, который используется для хеширования паролей пользователей.
         */
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
