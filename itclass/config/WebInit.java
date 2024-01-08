package by.itclass.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
// служит для инициализации создания единственного сервлета DispatcherServlet
// ОБЯЗАТЕЛЬНАЯ НАСЛЕДОВАТЬ
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];  // сторонние config (другие модули из spring)
        // горорит где лежит конфирурационные классы
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};  // -описание web mvc будет находиться в классе {AppConfig.class}
        // горорит где лежит конфирурационные классы
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};      // {"/"} - отлавливвает все запросы. работает с любым путем
    }
}
