package ua.recruitment.system.configuration.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import ua.recruitment.system.configuration.security.SecurityConfiguration;

/**
 * Created by KIRIL on 06.11.2016.
 */
@Configuration
@ComponentScan(basePackages = {"ua.recruitment.system.service", "ua.recruitment.system.facade"})
@Import(value = {RepositoryConfig.class, SecurityConfiguration.class})
public class ApplicationConfig {

}
