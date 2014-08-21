package ru.push.backend.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ru.push.backend.services.ServicePattern;
import ru.push.backend.services.UrmsuAndroidPushService;

@Configuration
@ComponentScan("ru.push.backend")
@EnableWebMvc
public class MainConfig {

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public ServicePattern ursmuAndroidStorage() {
        return new UrmsuAndroidPushService();
    }

}  
