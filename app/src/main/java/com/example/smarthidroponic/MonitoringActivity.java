package com.example.smarthidroponic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MonitoringActivity extends AppCompatActivity {
    private Button btnPh,btnTds,btnTur,btnHcsr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring);

        btnPh = findViewById(R.id.btn_ph_menu);
        btnTds = findViewById(R.id.btn_tds_menu);
        btnTur = findViewById(R.id.btn_turbidity_menu);
        btnHcsr = findViewById(R.id.btn_hcsr_menu);

        btnPh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MonitoringActivity.this,PhActivity.class);
                startActivity(i);
            }
        });

        btnTds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MonitoringActivity.this,TdsActivity.class);
                startActivity(i);
            }
        });

        btnTur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MonitoringActivity.this,TurbidityActivity.class);
                startActivity(i);
            }
        });

        btnHcsr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MonitoringActivity.this,HcsrActivity.class);
                startActivity(i);
            }
        });
    }
}