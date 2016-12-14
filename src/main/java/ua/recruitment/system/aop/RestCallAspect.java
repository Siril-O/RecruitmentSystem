package ua.recruitment.system.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by KIRIL on 14.12.2016.
 */
@Component
@Aspect
public class RestCallAspect {

    private static final Logger LOG = LoggerFactory.getLogger(RestCallAspect.class);

    @Around("within(ua.recruitment.system.web.controller..*) and" +
            " @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object loggRestCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //todo logging of rest calls and count hibernate queries
        Object resut = proceedingJoinPoint.proceed();
        return resut;
    }
}
