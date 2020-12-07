package com.example.a24802.demo.Model;

import java.util.List;

public class PagedResults<T> {
    private List<T> results;
    private int pageNumber;
    private String prevLink;
    private String nextLink;

    public PagedResults(){}

    public PagedResults(List<T> list, String baseUrl, int pageNumber, int pageSize) {
        for(int i = 0; i<results.size();i++){
    

        }
    }



    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPrevLink() {
        return prevLink;
    }

    public void setPrevLink(String prevLink) {
        this.prevLink = prevLink;
    }

    public String getNextLink() {
        return nextLink;
    }

    public void setNextLink(String nextLink) {
        this.nextLink = nextLink;
    }



 
  


}
