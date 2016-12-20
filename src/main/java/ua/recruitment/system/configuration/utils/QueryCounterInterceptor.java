package ua.recruitment.system.configuration.utils;

import org.hibernate.EmptyInterceptor;

/**
 * Created by KIRIL on 20.12.2016.
 */
public class QueryCounterInterceptor extends EmptyInterceptor {

    private ThreadLocal<Long> queryCounter = new ThreadLocal<>();

    public void startCounter() {
        queryCounter.set(0L);
    }

    public Long getQueryCount() {
        return queryCounter.get();
    }

    public void clearCounter() {
        queryCounter.remove();
    }

    @Override
    public String onPrepareStatement(String sql) {
        Long count = queryCounter.get();
        if (count != null) {
            queryCounter.set(count + 1);
        }
        return super.onPrepareStatement(sql);
    }
}
