package com.ycc.measures;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class spinner extends AppCompatActivity {

    private Spinner spinner;
    private Button button;
    private Button button2;
    private EditText editText;
    String value;
    int i=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner.this.setFinishOnTouchOutside(true);

        spinner = (Spinner) findViewById(R.id.spinner);
        String[] list = getResources().getStringArray(R.array.measure_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        editText = (EditText)findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.this.finish();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                i= spinner.getSelectedItemPosition();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    value = editText.getText().toString();
                if (value.equals("")) {
                    finish();
                }
                else {
                    Intent intent = new Intent();
                    intent.putExtra("no",String.valueOf(i));
                    intent.putExtra("value", value);
                    System.out.println(intent);
                    setResult(MainActivity.RESULT_OK, intent);
                    System.out.println(i + "ycc1ccc");
                    finish();
                }
            }
        });
    }




}
