package com.example.smarthidroponic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HcsrActivity extends AppCompatActivity {
    private Button hcsrVal;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference hcsrRef = database.getReference("transaction").child("hcsr");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hcsr);
        
        hcsrVal = findViewById(R.id.hcsr_val);
        
        hcsrRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer hcsr = snapshot.getValue(Integer.class);

                if(hcsr < 3.2 || hcsr >= 3.5){
                    hcsrVal.setBackgroundColor(getResources().getColor(R.color.merah));
                } else  if(hcsr <= 800 && hcsr >= 500){
                    hcsrVal.setBackgroundColor(getResources().getColor(R.color.ijo));
                }
                hcsrVal.setText(hcsr.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}