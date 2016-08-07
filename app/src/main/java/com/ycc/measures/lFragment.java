package com.ycc.measures;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class lFragment extends Fragment implements View.OnClickListener{
    private TextView casual,sports,suits;


    public lFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View lview = inflater.inflate(R.layout.fragment_l, container, false);
        casual = (TextView)lview.findViewById(R.id.casual);
        sports = (TextView)lview.findViewById(R.id.sports);
        suits = (TextView)lview.findViewById(R.id.suits);
        casual.setOnClickListener(this);
        sports.setOnClickListener(this);
        suits.setOnClickListener(this);

        return lview;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.casual:
                Intent intent1=new Intent("android.intent.action.casual");
                startActivity(intent1);
                break;
            case R.id.sports:
                Intent intent2=new Intent("android.intent.action.sports");
                startActivity(intent2);
                break;
            case R.id.suits:
                Intent intent3=new Intent("android.intent.action.suits");
                startActivity(intent3);
                break;
        }
    }
}
