package by.itclass.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};           // {AppConfig.class} -
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};                      // {"/"} - отлавливвает все запросы
    }
}
