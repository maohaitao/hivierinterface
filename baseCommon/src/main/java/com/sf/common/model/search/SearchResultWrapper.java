package com.sf.common.model.search;

import java.util.List;

/**
 * Created by YNzF on 2015/8/19.
 */
public class SearchResultWrapper<T extends SearchResultBase> {
    private int status;
    private int qTime;
    private long numFound;
    private long start;
    List<T> results;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getqTime() {
        return qTime;
    }

    public void setqTime(int qTime) {
        this.qTime = qTime;
    }

    public long getNumFound() {
        return numFound;
    }

    public void setNumFound(long numFound) {
        this.numFound = numFound;
    }

    public List<T> getResults() {

        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public static SearchResultWrapper emptyResult() {
        return new SearchResultWrapper();
    }
}
