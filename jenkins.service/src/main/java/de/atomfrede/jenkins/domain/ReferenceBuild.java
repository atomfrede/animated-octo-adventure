package de.atomfrede.jenkins.domain;

import java.io.Serializable;

public class ReferenceBuild implements Serializable {

    private int number;
    private String url;

    public ReferenceBuild setNumber(int number){
        this.number = number;
        return this;
    }

    public ReferenceBuild setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public String getUrl() {
        return url;
    }


}
