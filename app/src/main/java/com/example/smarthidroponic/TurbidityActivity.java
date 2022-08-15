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

public class TurbidityActivity extends AppCompatActivity {
    private Button turVal;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference turRef = database.getReference("transaction").child("turb");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turbidity);
        
        turVal = findViewById(R.id.tur_val);
        
        turRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer tur = snapshot.getValue(Integer.class);

                if(tur < 3.2 || tur > 100){
                    turVal.setBackgroundColor(getResources().getColor(R.color.merah));
                } else  if(tur < 3.2 && tur >= 3.5){
                    turVal.setBackgroundColor(getResources().getColor(R.color.ijo));
                }
                turVal.setText(tur.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}