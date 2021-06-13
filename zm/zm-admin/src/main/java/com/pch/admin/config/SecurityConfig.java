package com.pch.admin.config;

/*@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .successHandler(new AuthSuccessHandler("/main.html"))
                .failureHandler(new AuthFailHandler("/error.html"))
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login.html");
        //授权
        http.authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/error.html").permitAll()
                .antMatchers("/*").permitAll()
                .anyRequest().authenticated();

        //关闭防火墙
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder getPw() {
        return new BCryptPasswordEncoder();
    }
}*/
