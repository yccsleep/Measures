package com.ycc.measures;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class cFragment extends Fragment implements View.OnClickListener {
    private EditText etcm;
    private EditText etchi;
    private EditText etmi;
    private EditText etcm2;
    private EditText etus;
    private EditText etuk;
    private EditText etcn;
    private EditText eteu;
    private watcher[] watchers = new watcher[8];
    private int[] btidNum = { R.id.one, R.id.two, R.id.three, R.id.four, R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.zero, R.id.del,R.id.dot,R.id.reg,R.id.shoes};
    private Button[] buttons = new Button[btidNum.length];
    private String temp="";
    private LinearLayout mLinearLayout;
    private View fragment_g;
    private View fragment_s;
    private View cview;



    public cFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
         cview = inflater.inflate(R.layout.fragment_c, container, false);

        fragment_g = cview.inflate(getActivity(),R.layout.fragment_g,null);
        fragment_s = cview.inflate(getActivity(),R.layout.fragment_s,null);

        mLinearLayout = (LinearLayout)cview.findViewById(R.id.switch_f);
        mLinearLayout.addView(fragment_g);


        etcm = (EditText) fragment_g.findViewById(R.id.etcm);
//        etcm.setBackgroundColor(Color.);
        etchi = (EditText) fragment_g.findViewById(R.id.etchi);
        etmi = (EditText) fragment_g.findViewById(R.id.etmi);
        etcm2 = (EditText) fragment_s.findViewById(R.id.etcm2);
        etuk = (EditText) fragment_s.findViewById(R.id.etuk);
        etus = (EditText) fragment_s.findViewById(R.id.etus);
        eteu = (EditText) fragment_s.findViewById(R.id.eteu);
        etcn = (EditText) fragment_s.findViewById(R.id.etcn);


        etchi.setInputType(InputType.TYPE_NULL);
        etcm.setInputType(InputType.TYPE_NULL);
        etmi.setInputType(InputType.TYPE_NULL);
        etcm2.setInputType(InputType.TYPE_NULL);
        etus.setInputType(InputType.TYPE_NULL);
        etuk.setInputType(InputType.TYPE_NULL);
        etcn.setInputType(InputType.TYPE_NULL);
        eteu.setInputType(InputType.TYPE_NULL);


        for (int i = 0; i < btidNum.length; i++) {
            buttons[i] = (Button)cview.findViewById(btidNum[i]);
            buttons[i].setOnClickListener(this);
        }


        watchers[0]=new watcher(etcm,etchi,etmi,0);
        watchers[1]=new watcher(etchi,etcm,etmi,1);
        watchers[2]=new watcher(etmi,etcm,etchi,2);
        watchers[3]=new watcher(etcm2,etus,eteu,etuk,etcn,3);
        watchers[4]=new watcher(etus,etcm2,eteu,etuk,etcn,4);
        watchers[5]=new watcher(eteu,etcm2,etus,etuk,etcn,5);
        watchers[6]=new watcher(etuk,etcm2,etus,eteu,etcn,6);
        watchers[7]=new watcher(etcn,etcm2,etus,eteu,etuk,7);

        etcm.setOnFocusChangeListener(new android.view.View.
                OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus&&etchi.hasFocus()) {
                    temp = etchi.getText().toString();
                }else if (!hasFocus&&etmi.hasFocus()) {
                    temp = etmi.getText().toString();
                }
            }
        });
        etchi.setOnFocusChangeListener(new android.view.View.
                OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus&&etcm.hasFocus()) {
                    temp = etcm.getText().toString();
                }else if(!hasFocus&&etmi.hasFocus()) {
                    temp = etmi.getText().toString();
                }
            }
        });
        etmi.setOnFocusChangeListener(new android.view.View.
                OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus&&etcm.hasFocus()) {
                    temp = etcm.getText().toString();
                }else if (!hasFocus&&etchi.hasFocus()) {
                    temp = etchi.getText().toString();
                }
            }
        });
        return cview;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.one:
                temp+="1";
                break;
            case R.id.two:
                temp+="2";
                break;
            case R.id.three:
                temp+="3";
                break;
            case R.id.four:
                temp+="4";
                break;
            case R.id.five:
                temp+="5";
                break;
            case R.id.six:
                temp+="6";
                break;
            case R.id.seven:
                temp+="7";
                break;
            case R.id.eight:
                temp+="8";
                break;
            case R.id.nine:
                temp+="9";
                break;
            case R.id.zero:
                temp+="0";
                break;
            case R.id.dot:
            if(temp.length()>0&&!temp.contains("."))
                temp+=".";
                break;
            case R.id.del:
                if(temp.length()>0){
                temp=temp.substring(0,temp.length()-1);
                }else{
                    temp="";
                }
                break;
            case R.id.shoes:
                if(!fragment_s.isShown()){
                mLinearLayout.removeView(fragment_g);
                mLinearLayout.addView(fragment_s);
                    etcm2.requestFocus();
                }
                break;
            case R.id.reg:
                if(!fragment_g.isShown()){
                    mLinearLayout.removeView(fragment_s);
                    mLinearLayout.addView(fragment_g);
                    etcm.requestFocus();
                }
                break;
            default:
                break;
        }
        if (etcm.isFocused()) {
            etcm.addTextChangedListener(watchers[0]);
            etcm.setText(temp);
            etcm.removeTextChangedListener(watchers[0]);
        }
        if (etchi.isFocused()) {
            etchi.addTextChangedListener(watchers[1]);
            etchi.setText(temp);
            etchi.removeTextChangedListener(watchers[1]);
        }
        if (etmi.isFocused()) {
            etmi.addTextChangedListener(watchers[2]);
            if(temp.length()>0&&temp.substring(temp.length()-1,temp.length()).equals(".")){
            temp = temp.substring(0, temp.length() -1);}
            etmi.setText(temp);
            etmi.removeTextChangedListener(watchers[2]);
        }
        if (etcm2.isFocused()) {
            etcm2.addTextChangedListener(watchers[3]);
            etcm2.setText(temp);
            etcm2.removeTextChangedListener(watchers[3]);
        }
        if (etus.isFocused()) {
            etus.addTextChangedListener(watchers[4]);
            etus.setText(temp);
            etus.removeTextChangedListener(watchers[4]);
        }
        if (eteu.isFocused()) {
            eteu.addTextChangedListener(watchers[5]);
            eteu.setText(temp);
            eteu.removeTextChangedListener(watchers[5]);
        }
        if (etuk.isFocused()) {
            etuk.addTextChangedListener(watchers[6]);
            etuk.setText(temp);
            etuk.removeTextChangedListener(watchers[6]);
        }
        if (etcn.isFocused()) {
            etcn.addTextChangedListener(watchers[7]);
            etcn.setText(temp);
            etcn.removeTextChangedListener(watchers[7]);
        }
    }

}