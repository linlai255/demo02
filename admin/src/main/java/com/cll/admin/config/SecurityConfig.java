package com.cll.admin.config;

import com.cll.admin.component.JWTAuthenticationFilter;
import com.cll.admin.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailsService userDetailsService;
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**");
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
        super.configure(auth);
    }
    public static final String[] AUTH_WHITELIST = {
            "/admin/login","/admin/register","/swagger-ui.html","/swagger-resources/**","/swagger/**","/api/**",
            "/swagger-resources/configuration/ui","/swagger-resources/configuration/security","/swagger-resources",
            "/webjars/**","/v2/api-docs"
            // other public endpoints of your API may be appended to this array
    };
    @Bean
    public PasswordEncoder password(){return new BCryptPasswordEncoder(); }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                //??????????????????JWT????????????????????????csrf
                .csrf().disable()
                //??????token??????????????????session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                //???????????????????????????
                .antMatchers(AUTH_WHITELIST).permitAll()
                //????????????????????????????????????
                .and().logout().logoutUrl("*/logout").permitAll()
                .and()
                //.addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JWTAuthenticationFilter(authenticationManager()));

    }
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
