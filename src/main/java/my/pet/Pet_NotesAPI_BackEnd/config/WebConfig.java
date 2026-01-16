package my.pet.Pet_NotesAPI_BackEnd.config;

import lombok.RequiredArgsConstructor;
import my.pet.Pet_NotesAPI_BackEnd.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final LoggingInterceptor logger;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logger)
        .addPathPatterns("/**");
    }
}
