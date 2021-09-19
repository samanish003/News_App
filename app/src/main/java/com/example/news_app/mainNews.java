package com.example.news_app;

import java.util.ArrayList;

public class mainNews {

    private String status;
    private String totalResult;
    private ArrayList<ModelClass> sources;

    public mainNews(String status, String totalResult, ArrayList<ModelClass> sources) {
        this.status = status;
        this.totalResult = totalResult;
        this.sources = sources;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(String totalResult) {
        this.totalResult = totalResult;
    }

    public ArrayList<ModelClass> getSources() {
        System.out.println(sources);
        return sources;
    }

    public void setSources(ArrayList<ModelClass> sources) {
        this.sources = sources;
    }
}
