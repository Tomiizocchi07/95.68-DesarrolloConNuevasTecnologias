package com.fiuba.VentaDeuda.Web;

import com.fiuba.VentaDeuda.Service.ServiceIMPL.UserDetailsServiceIMPL;
import com.fiuba.VentaDeuda.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsServiceIMPL userDetailsServiceIMPL;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure (AuthenticationManagerBuilder build) throws Exception{
        build.userDetailsService(userDetailsServiceIMPL).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/","/auth/**").permitAll().anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/auth/login").defaultSuccessUrl("/deudas/listado",true).failureUrl("/auth/login?error=true")
                .loginProcessingUrl("/auth/login-post").permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/public/index");
    }
}