package com.example.srinivasjavvaji.loginapp;

/**
 * Created by Srinivas Javvaji on 12/14/2015.
 */

import java.text.NumberFormat;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import loginAction.DueDetails;
import loginAction.User;


public class DueListAdapter extends ArrayAdapter<DueDetails>{
    private List<DueDetails> items;

    public DueListAdapter(Context context, List<DueDetails> items) {
        super(context, R.layout.app_custom_list, items);
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null) {
            LayoutInflater li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.app_custom_list, null);
        }

        DueDetails dueDetails = items.get(position);

        if(dueDetails != null) {
//            ImageView icon = (ImageView)v.findViewById(R.id.appIcon);
            TextView partyName = (TextView)v.findViewById(R.id.titleTxt);
//            LinearLayout ratingCntr = (LinearLayout)v.findViewById(R.id.ratingCntr);
            TextView dlText = (TextView)v.findViewById(R.id.dlTxt);
            Button partyDetails = (Button) v.findViewById(R.id.party_details);

            partyDetails.setText(dueDetails.getParty_id());
            partyDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button b = (Button)v;
                    String buttonText = b.getText().toString();
                    System.out.println(" list button clicked"+buttonText);
                }
            });

//            if(icon != null) {
//                Resources res = getContext().getResources();
//                String sIcon = "com.example.srinivasjavvaji.loginapp:drawable/" + app.getIcon();
//                icon.setImageDrawable(res.getDrawable(res.getIdentifier(sIcon, null, null)));
//            }

            if(partyName != null) partyName.setText(dueDetails.getParty_name());

            if(dlText != null) {
                NumberFormat nf = NumberFormat.getNumberInstance();
                dlText.setText(nf.format(dueDetails.getPending_amt())+" dl");
            }


        }

        return v;
    }
}