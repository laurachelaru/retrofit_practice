package com.ncr.aw.retrofitpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ncr.aw.retrofitpractice.model.model;

import java.util.List;

public class MyAdapter extends ArrayAdapter {

    private List<model> zones;

    public MyAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.zones = objects;
    }

    @Override
    public int getCount() {
        return this.zones.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.activity_listview, null);
        TextView textIdView = (TextView) v.findViewById(R.id.zoneId);
        TextView textNameView = (TextView) v.findViewById(R.id.zoneName);
        textIdView.setText(zones.get(position).getId());
        textNameView.setText(zones.get(position).getName());
        return v;

    }
}
