package com.ycc.measures;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;


/**
 * Created by 杨云期 on 2016/6/23.
 */
public class mFragment extends Fragment {
    private FloatingActionButton fab1;
    private String recTag;
    private String recData;
    private String[] tag = {"头围：","肩宽：","胸围：","腰围："};
    private int i;
    private TextView[] textView = new TextView[4];
    private String[] restore= new String[4];


    public mFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_m, container, false);
        fab1 = (FloatingActionButton) view.findViewById(R.id.fab1);
        int[] textViewID = {R.id.textView0,R.id.textView1, R.id.textView2,R.id.textView3};
        for (int j=0;j<=3;j++){
            textView[j] = (TextView)view.findViewById(textViewID[j]);
        }

        SharedPreferences pref = getActivity().getSharedPreferences("data",
                    MODE_PRIVATE);
        for (int k=0;k<=3;k++){
            restore[k] = pref.getString(tag[k], "");
            if (restore[k]!=null)
                textView[k].setText(tag[k]+restore[k]);
            Log.d("YCCCQ",k+tag[k]+restore[k]);
        }



        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fab1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.spinner");
                startActivityForResult(intent,1);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
            switch (requestCode){
                case 1:
                if(resultCode == MainActivity.RESULT_OK){
                    recTag = data.getStringExtra("no");
                    i = Integer.valueOf(recTag);
                    recData = data.getStringExtra("value");
                    textView[i].setText(tag[i]+recData);
                    Log.d("yoyo",recTag);

                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("data",
                            MODE_PRIVATE).edit();
                    editor.putString(tag[i],recData );
                    editor.commit();
            }
            break;
            default:
            }
        }

}

