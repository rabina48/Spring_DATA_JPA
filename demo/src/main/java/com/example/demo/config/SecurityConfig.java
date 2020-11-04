package com.example.demo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

import static org.hibernate.criterion.Restrictions.and;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
               .csrf().disable()
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())

                .authorizeRequests()
                .antMatchers("/","index","/css/*","/js/*" )
                .permitAll()
                .antMatchers("/users/**").hasRole("ASD")

                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/loginpage").permitAll()
                .defaultSuccessUrl("/course",true)
                 .and()

                .rememberMe()
                    .tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(60))
                     .key("go")
                .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))

                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login");

    }

//    @Override
//    protected  void  UserService
}
