package ru.maxima.dispatcherservlet.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext){
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ViewConfig.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("viewDispatcher", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");


        AnnotationConfigWebApplicationContext apiContext = new AnnotationConfigWebApplicationContext();
        apiContext.register(ApiConfig.class);

        ServletRegistration.Dynamic apiDispatcher = servletContext.addServlet("apiDispatcher", new DispatcherServlet(apiContext));
        apiDispatcher.setLoadOnStartup(1);
        apiDispatcher.addMapping("/api/*");
    }
}

