package com.ncr.aw.retrofitpractice.model;

import com.google.gson.annotations.Expose;

/**
 * Created by aw2 on 9/9/2016.
 */
public class model {

    @Expose
    private String name;
    @Expose
    private Integer id;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
