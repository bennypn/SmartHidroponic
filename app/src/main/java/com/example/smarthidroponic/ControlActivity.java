package com.example.smarthidroponic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ControlActivity extends AppCompatActivity {

    private Switch nutrisiASW,nutrisiBSW,phUpSw,phDownSw,autoSw;
    private Button btnMixer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        nutrisiASW = findViewById(R.id.nutrisiA_sw);
        phUpSw = findViewById(R.id.phUp_sw);
        phDownSw = findViewById(R.id.phDown_sw);
        nutrisiBSW = findViewById(R.id.nutrisiB_sw);
        autoSw = findViewById(R.id.auto_sw);
        btnMixer = findViewById(R.id.btn_mixer_menu);

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://smarthidroponic-default-rtdb.asia-southeast1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("control");

        btnMixer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ControlActivity.this,MixerActivity.class);
                startActivity(i);
            }

        });

        nutrisiASW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Log.v("Switch State=", ""+isChecked);
                myRef.child("nutrisiA").setValue(isChecked);
            }
        });

        nutrisiBSW.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Log.v("Switch State=", ""+isChecked);
                myRef.child("nutrisiB").setValue(isChecked);
            }
        });

        phUpSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Log.v("Switch State=", ""+isChecked);
                myRef.child("phUp").setValue(isChecked);
            }
        });

        phDownSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Log.v("Switch State=", ""+isChecked);
                myRef.child("phDown").setValue(isChecked);
            }
        });

        autoSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Log.v("Switch State=", ""+isChecked);
                myRef.child("auto").setValue(isChecked);
                if(!isChecked){
                    nutrisiASW.setClickable(false);
                    nutrisiBSW.setClickable(false);
                    phUpSw.setClickable(false);
                    phDownSw.setClickable(false);
                } else {
                    nutrisiASW.setClickable(true);
                    nutrisiBSW.setClickable(true);
                    phUpSw.setClickable(true);
                    phDownSw.setClickable(true);
                }
            }
        });





    }
}