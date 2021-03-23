package org.uhms.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> myWebAuthenticationDetailsSource;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                .antMatchers("/app/api/**", "/captcha.jpg").permitAll()
                .anyRequest().authenticated()
                .and()
                .rememberMe()
                .userDetailsService(userDetailsService)
                .and()
                .csrf().disable()
                .formLogin()
                .authenticationDetailsSource(myWebAuthenticationDetailsSource)
                .loginPage("/myLogin.html")
                .loginProcessingUrl("/auth/form").permitAll()
                .failureHandler(new MyAuthenticationFailureHandler());
        http.addFilterBefore(new VerificationCodeFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authenticationProvider);
//        auth.inMemoryAuthentication()
//                .withUser("admin").password(bCryptPasswordEncoder().encode("123456")).roles("ADMIN")
//                .and()
//                .withUser("zhangzijun").password(bCryptPasswordEncoder().encode("123456")).roles("ADMIN");
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
//        jdbcUserDetailsManager.setDataSource(dataSource);
//        jdbcUserDetailsManager.createUser(User.withUsername("user").password("123").roles("USER").build());
//        jdbcUserDetailsManager.createUser(User.withUsername("admin").password("123").roles("ADMIN","ADMIN").build());
//        return jdbcUserDetailsManager;
//    }
}
