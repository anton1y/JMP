package jmp.spring.mvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication().withUser("admin").password("password").authorities("ROLE_ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.authorizeRequests().antMatchers("/customers/delete/**","/customers/add/**","/customers/save/**", "/customers/edit/**", "/checkSession/").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/customers/").permitAll()
                .and().formLogin()
                .loginPage("/loginPage").defaultSuccessUrl("/customers/").failureUrl("/loginPage?error")
                .usernameParameter("username").passwordParameter("password").and().logout()
                .logoutSuccessUrl("/loginPage?logout");
    }
}