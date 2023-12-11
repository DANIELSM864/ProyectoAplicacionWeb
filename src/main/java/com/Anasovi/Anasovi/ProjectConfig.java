package com.Anasovi.Anasovi;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setTimeZoneAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(
            InterceptorRegistry registro) {
        registro.addInterceptor(
                localeChangeInterceptor()
        );
    }

    /* Los siguiente métodos son para implementar el tema de seguridad dentro del proyecto */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/", "/index", "/errores/**",
                        "/carrito/**", "/consulta/paginaConsulta",
                        "noticia/paginaNoticia", "/evento/paginaEvento",
                        "/categoria/paginaCategoria", "/donacion/paginaDonacion",
                        "/informate/paginaInformate", "/templates/index",
                        "/registro/**", "/js/**",
                        "/webjars/**", "producto/paginaProducto")
                .permitAll()
                .requestMatchers(
                        "/templates/index", "/consulta/paginaConsulta",
                        "/noticia/paginaNoticia", "/evento/paginaEvento",
                        "/producto/paginaProducto", "/categoria/paginaCategoria",
                        "/categoria/modificar/**", "/categoria/eliminar/**",
                        "/donacion/nuevoD", "/donacion/eliminar/**",
                        "/donacion/paginaDonacion", "/donacion/modificar/**",
                        "/informate/paginaInformate", "/noticia/paginaNoticia",
                        "/evento/paginaEvento", "/usuario/paginaUsuario",
                        "/usuario/eliminar/**", "/usuario/modificar/**",
                        "/usuario/nuevo", "/usuario/nuevoD",
                        "/usuario/guardar","/consulta/ver/**",
                        "/consulta/eliminar/**","/noticia/nuevo",
                        "/noticia/guardar","/noticia/modificar/**",
                        "/noticia/eliminar/**","/evento/nuevo",
                        "/evento/guardar","/evento/modificar/**",
                        "/evento/eliminar/**","/producto/guardar",
                        "/producto/modificar/**","/producto/eliminar/**",
                        "/categoria/guardar","/donacion/guardar","/usuario/eliminar/**"
                ).hasRole("ADMIN")
                .requestMatchers("/facturar/carrito","/consulta/guardar")
                .hasRole("USER")
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

//    @Bean
//    public UserDetailsService users() {
//        UserDetails admin = org.springframework.security.core.userdetails.User.builder()
//                .username("juan")
//                .password("{noop}123")
//                .roles("USER", "ADMIN")
//                .build();
//        UserDetails user = org.springframework.security.core.userdetails.User.builder()
//                .username("pedro")
//                .password("{noop}789")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
