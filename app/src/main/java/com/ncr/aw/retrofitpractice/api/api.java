package com.ncr.aw.retrofitpractice.api;

import com.ncr.aw.retrofitpractice.model.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by aw2 on 9/9/2016.
 */
public interface api {

    @GET("public/zones")
    Call<List<model>> getAllZones();
}
