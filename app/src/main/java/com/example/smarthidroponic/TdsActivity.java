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

public class TdsActivity extends AppCompatActivity {
    private Button tdsVal, btnPh, btnControl;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 = database.getReference("transaction").child("tds");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tds);

        tdsVal = findViewById(R.id.tds_val);
        btnPh = findViewById(R.id.btn_ph);
        btnControl = findViewById(R.id.btn_control);

        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer tds = dataSnapshot.getValue(Integer.class);

                if(tds <= 1050 || tds > 1400){
                    tdsVal.setBackgroundColor(getResources().getColor(R.color.merah));
                } else if((tds>1050 && tds<1150) || (tds>1300 && tds<=1400)){
                    tdsVal.setBackgroundColor(getResources().getColor(R.color.kuning));
                } else  if(tds <= 1300 && tds >= 1150){
                    tdsVal.setBackgroundColor(getResources().getColor(R.color.ijo));
                }
                tdsVal.setText(tds.toString());

            }
            @Override
            public void onCancelled(DatabaseError error) {  }
        });

        btnPh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TdsActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}