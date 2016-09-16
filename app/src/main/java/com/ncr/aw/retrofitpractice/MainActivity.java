package com.ncr.aw.retrofitpractice;

import android.app.ListActivity;
import android.graphics.Movie;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ncr.aw.retrofitpractice.api.api;
import com.ncr.aw.retrofitpractice.model.model;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static final String BASE_URL = "http://ncr.aesthetic-works.net/api/";
    SimpleCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api apiService = retrofit.create(api.class);

        Call<List<model>> call = apiService.getAllZones();
        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                int statusCode = response.code();
                List<model> arrZones = response.body();

                MyAdapter adapter = new MyAdapter(MainActivity.this, R.layout.activity_listview, arrZones);

                ListView listView = (ListView) findViewById(R.id.simpleListView);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {
                // Log error here since request failed
            }
        });
    }
}
