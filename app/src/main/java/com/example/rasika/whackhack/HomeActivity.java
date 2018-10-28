package com.example.rasika.whackhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button btnRooms;
    private Button btnWorkStations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnRooms = (Button)findViewById(R.id.btn_rooms);
        btnWorkStations = (Button) findViewById(R.id.btn_work_stations);

        btnRooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectToRoomPage();
            }
        });

        btnWorkStations.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                redirectToWsPage();
            }
        });

    }
    private void redirectToRoomPage(){
        startActivity(new Intent(HomeActivity.this, RoomActivity.class));
    }

    private void redirectToWsPage(){
        startActivity(new Intent(HomeActivity.this, WorkstationActivity.class));
    }

}
