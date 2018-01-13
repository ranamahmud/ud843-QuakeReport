package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import java.util.ArrayList;

/**
 * Created by Md Rana Mahmud on 1/12/2018.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    String primaryLocation;
    String locationOffset;
    private static final String LOCATION_SEPERATOR =  " of ";
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
        String originalLocation = currentEarthquake.getLocation();

        TextView magnitudeTextView = listItemView.findViewById(R.id.magnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        int magnitudeColor =  getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);
        String magnitude = String.valueOf(currentEarthquake.getMagnitude());
        magnitudeTextView.setText(magnitude);

        if(originalLocation.contains(LOCATION_SEPERATOR)){
            String[] parts = originalLocation.split(LOCATION_SEPERATOR);
            locationOffset = parts[0] + LOCATION_SEPERATOR;
            primaryLocation = parts[1];
        }
        else{
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }
        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);

        TextView dateTextView = listItemView.findViewById(R.id.date);
        dateTextView.setText(currentEarthquake.getDate());

        return  listItemView;
    }

    private int getMagnitudeColor(String magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(Double.parseDouble(magnitude));
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
