package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc //@EnableWebMvc is an annotation in Spring Framework that is used to enable Spring MVC configuration
@ComponentScan("com.tpe")  //to scan beans from the package specified .
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);  //which is a class in the Java Standard Tag Library (JSTL) used to simplify writing JSP pages
        resolver.setPrefix("/WEB-INF/views/"); //property to the location of the view files
        resolver.setSuffix(".jsp");           // property to the file extension of the view files.
        return resolver;
    }

    @Override    // we are setting the location of our resources(CSS,image)
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").   //http://localhost:8080/SpringMvc/resources/css/style.css
                addResourceLocations("/resources/").  //method specifies the location of resources.
                setCachePeriod(0);   //used to specify the duration for which the resources should be cached
    }

}
/*
		/com/tpe/**
		--> RootContextConfig, WebAppIni, WebMvcConfig, etc.
 */