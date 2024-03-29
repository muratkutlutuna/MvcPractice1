package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//instead of web.xml we can use Class Config
// we need to register dispatcher Servlet

//AbstractAnnotationConfigDispatcherServletInitializer is used to start dispatcher servlet
//used to configure and initialize the DispatcherServlet for a Spring-based web application
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //DispatcherServlet: It is the front controller in Spring MVC that receives all incoming requests.

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {
                RootContextConfig.class		// Configurations about DB and hibernate.
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                WebMvcConfig.class				// Configurations about SpringMVC. This is where beans are held at.
        };
    }

    @Override
    protected String[] getServletMappings() {

        return new String[] {"/"};  //DispatcherServlet should handle all requests that come in with the root URL /.
    }								//http://localhost:8080/SpringMvc/


}