package ua.recruitment.system.configuration.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by KIRIL on 06.11.2016.
 */
@Configuration
@ComponentScan(basePackages = {"ua.recruitment.system.service"})
@Import(value = {RepositoryConfig.class})
public class ApplicationConfig {
}
