package com.example.cloudmusicdemo.bean;

import java.util.List;



public class NewPlayListResponse {


    private String className;
    private List<NewPlayListResultsBean> results;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<NewPlayListResultsBean> getResults() {
        return results;
    }

    public void setResults(List<NewPlayListResultsBean> results) {
        this.results = results;
    }


}
