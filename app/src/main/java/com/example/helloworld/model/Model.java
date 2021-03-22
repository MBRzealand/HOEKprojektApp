package com.example.helloworld.model;

import java.io.Serializable;

public class Model implements Serializable {

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
