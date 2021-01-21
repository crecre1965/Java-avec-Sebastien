package com.bnpparibas.itg.mylibraries.libraries.infrastructure;

import com.bnpparibas.itg.mylibraries.libraries.infrastructure.users.Users;
import com.bnpparibas.itg.mylibraries.libraries.infrastructure.users.UsersDAO;
import com.sun.deploy.net.CanceledDownloadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import javax.sql.DataSource;
import java.util.Arrays;

//@Profile("dev")
@Configuration
@EnableGlobalMethodSecurity(
        securedEnabled = true,  //@Secured("ROLE_ADMIN")
        jsr250Enabled = true,   //@RolesAllowed("ADMIN")
        prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UsersDAO userDAO;
    @Autowired
    DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        //roles : dans ce cas le role est préfixé par ROLE_ dans la BDD. si la valeur du role n'est pas préfixé,
        // SPRING le cree a ROLE_USER
        //authorities : dans ce cas l'authority  reste telle que (non préfixé par ROLE_) dans la BDD
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordEncoder().encode("123"))
//                .roles("ADMIN")
//                .and()
//                .withUser("user")
//                .password(passwordEncoder().encode("123"))
//                .roles("USER");


//        Pour aller chercher les utilisateurs en base
//      Les deux lignes ci-dessous sont uniquement là pour créer des utilisateurs au démarrage de l'application
//      Dans une "réelle" application les utilisateurs sont déjà présents en base (ou créés via un service d'inscription par exemple)
        userDAO.save(new Users("user", passwordEncoder().encode("123"), true, Arrays.asList("ROLE_USER")));
        userDAO.save(new Users("admin", passwordEncoder().encode("123"), true, Arrays.asList("ROLE_ADMIN")));

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, active"
                + "from users "
                +"where username=?")
                .authoritiesByUsernameQuery("select users_username, roles "
                + "from users_roles "
                + "where users_username = ?");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests()
                //api unsecuried/toto est désécuriséee
                // appi unsecured/toto/tata est désuriqée
                .antMatchers("/unsecured/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/**.css").permitAll()
                .antMatchers(
                        "/", "/csrf",
                        "/v2/api-docs",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/webjars/**"
                ).permitAll()

                .anyRequest().authenticated()
//                .and().csrf().ignoringAntMatchers("/h2-console/**")
                .and()
                .headers().frameOptions().disable()
                .and()
                .csrf().disable()
                //              .httpBasic()
                .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.getWriter().println("Autentification effectuée !");
                })
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.getWriter().println("Logout effectué !");})
                .and()

                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()

                .csrf().disable()

                .headers().frameOptions().disable(); //for H2-console
        ;
    }



}

