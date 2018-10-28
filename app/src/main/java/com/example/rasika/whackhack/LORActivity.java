package com.example.rasika.whackhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class LORActivity extends AppCompatActivity {

    RecyclerView rvListOfRooms;
    private ListOfRoomsAdapter listOfRoomsAdapter;

    ArrayList<String> strings = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        strings = this.getIntent().getStringArrayListExtra("ROOMS_ARRAY");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lor);

        rvListOfRooms = (RecyclerView) findViewById(R.id.rv_rooms_list);
        rvListOfRooms.setHasFixedSize(true);
        Log.d("LORAct", "Size: " + strings.size());
        listOfRoomsAdapter = new ListOfRoomsAdapter(strings, getBaseContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        rvListOfRooms.setLayoutManager(layoutManager);
        listOfRoomsAdapter.setOnItemClickListener(new ListOfRoomsAdapter.RoomClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(getBaseContext(), strings.get(position) + "selected", Toast.LENGTH_LONG).show();
            }
        });
        rvListOfRooms.setAdapter(listOfRoomsAdapter);
        rvListOfRooms.addItemDecoration(new DividerItemDecoration(getBaseContext(), DividerItemDecoration.VERTICAL));


    }
}
