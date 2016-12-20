package ua.recruitment.system.web.controller.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ua.recruitment.system.configuration.utils.QueryCounterInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by KIRIL on 20.12.2016.
 */
public class LoggingInterceptor implements AsyncHandlerInterceptor {

    private ThreadLocal<Long> time = new ThreadLocal<>();

    private static final Logger LOG = LoggerFactory.getLogger(LoggingInterceptor.class);

    @Autowired
    private QueryCounterInterceptor queryCounterInterceptor;

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        queryCounterInterceptor.clearCounter();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        time.set(System.currentTimeMillis());
        queryCounterInterceptor.startCounter();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long executionTime = System.currentTimeMillis() - time.get();
        Long queryCount = queryCounterInterceptor.getQueryCount();
        queryCounterInterceptor.clearCounter();
        time.remove();
        logRequest(request, (HandlerMethod) handler, executionTime, queryCount);
    }


    private void logRequest(HttpServletRequest request, HandlerMethod handler, long executionTime, Long queryCount) {
        LOG.info("Request to path:{} handled by:{}.{} with arguments:{}. Execution time:{}. Executed queries:{}.",
                request.getServletPath(), handler.getBeanType().getName(), handler.getMethod().getName(), request.getQueryString(),
                executionTime, queryCount);
    }
}
