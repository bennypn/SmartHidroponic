package com.example.smarthidroponic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnMenuMon, btnMenuCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMenuCon = findViewById(R.id.btn_menu_controlling);
        btnMenuMon = findViewById(R.id.btn_menu_monitoring);

        btnMenuMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MonitoringActivity.class);
                startActivity(i);
            }
        });

        btnMenuCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ControlActivity.class);
                startActivity(i);
            }
        });


    }
}