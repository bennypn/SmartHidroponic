package com.example.smarthidroponic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MixerActivity extends AppCompatActivity {
    private Switch mixerSw, waterSw, tankSw;
    private Button btnCtrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mixer);

        mixerSw = findViewById(R.id.mixer_sw);
        waterSw = findViewById(R.id.water_sw);
        tankSw = findViewById(R.id.tank_sw);
        btnCtrl = findViewById(R.id.btn_control_back);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("control");

        btnCtrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MixerActivity.this,ControlActivity.class);
                startActivity(i);
            }
        });

        mixerSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Log.v("Switch State=", ""+isChecked);
                myRef.child("mixer").setValue(isChecked);
            }
        });

        waterSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Log.v("Switch State=", ""+isChecked);
                myRef.child("waterDrain").setValue(isChecked);
            }

        });

        tankSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Log.v("Switch State=", ""+isChecked);
                myRef.child("pumpState").setValue(isChecked);
            }
        });

    }
}