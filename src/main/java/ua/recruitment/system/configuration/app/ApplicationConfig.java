package ua.recruitment.system.configuration.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * Created by KIRIL on 06.11.2016.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"ua.recruitment.system.service", "ua.recruitment.system.facade", "ua.recruitment.system.aop"})
@Import(value = {RepositoryConfig.class})
public class ApplicationConfig {

}
