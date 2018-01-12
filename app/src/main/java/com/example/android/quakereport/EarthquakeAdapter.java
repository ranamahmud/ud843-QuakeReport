package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Md Rana Mahmud on 1/12/2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent, false
            );
        }
        Earthquake currentEarthquake = getItem(position);
        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude);
        magnitudeTextView.setText(currentEarthquake.getMagnitude());
        TextView locationTextView = listItemView.findViewById(R.id.location);
        locationTextView.setText(currentEarthquake.getLocation());
        TextView dateTextView = listItemView.findViewById(R.id.date);
        dateTextView.setText(currentEarthquake.getDate());

        return  listItemView;
    }
}
