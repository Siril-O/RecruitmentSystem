package ua.recruitment.system.repository.util;

/**
 * Created by KIRIL on 08.11.2016.
 */
public class Paging {
    private Integer startPosition;
    private Integer maxResults;

    public Integer getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }

    public Integer getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
    }
}
