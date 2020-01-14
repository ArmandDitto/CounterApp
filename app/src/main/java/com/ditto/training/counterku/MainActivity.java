package com.ditto.training.counterku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //pembuatan objek komponen
    TextView tvCount;
    Button buttonCount, buttonReset;
    int count=0;
    private final String STATE_COUNT = "state_count"; //Membuat Konstanta state_count untuk menyimpan state count

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //bind layout yang akan ditampilkan

        //bind komponen ke view
        tvCount =findViewById(R.id.tv_count);
        buttonCount=findViewById(R.id.button_count);
        buttonReset=findViewById(R.id.button_reset);

        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                tvCount.setText(String.valueOf(count));
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=0;
                tvCount.setText(String.valueOf(count));
            }
        });

        if (savedInstanceState!=null){
            count = savedInstanceState.getInt(STATE_COUNT);
            tvCount.setText(String.valueOf(count));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //Menyimpan State
        outState.putInt(STATE_COUNT,count);
    }


}
