package jmp.spring.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jmp.spring.core.configs.CustomerInitializerConfig;
import jmp.spring.core.configs.RepositoryConfig;
import jmp.spring.core.configs.ServiceConfig;

public class MVCInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
            WebMVCConfig.class,
            CustomerInitializerConfig.class,
            RepositoryConfig.class,
            ServiceConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {

        return new Class<?>[]{
                WebMVCConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
