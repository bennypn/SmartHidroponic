package com.example.smarthidroponic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PhActivity extends AppCompatActivity {
    private Button phVal, btnTds, btnControl;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("transaction").child("ph");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph);

        phVal = findViewById(R.id.ph_val);
        btnControl = findViewById(R.id.ph_val);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Float ph = dataSnapshot.getValue(Float.class);

                if(ph < 5.5 || ph > 6.5){
                    phVal.setBackgroundColor(getResources().getColor(R.color.merah));
                } else  if(ph <= 6.5 && ph >= 5.5){
                    phVal.setBackgroundColor(getResources().getColor(R.color.ijo));
                }
                phVal.setText(ph.toString());

            }
            @Override
            public void onCancelled(DatabaseError error) {  }
        });


        btnControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PhActivity.this,ControlActivity.class);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}