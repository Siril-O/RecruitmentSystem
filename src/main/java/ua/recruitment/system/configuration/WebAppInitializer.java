package ua.recruitment.system.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ua.recruitment.system.configuration.app.ApplicationConfig;
import ua.recruitment.system.configuration.security.SecurityConfiguration;
import ua.recruitment.system.configuration.web.WebConfiguration;

/**
 * Created by KIRIL on 06.11.2016.
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class, SecurityConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
