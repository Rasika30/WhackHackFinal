package com.example.rasika.whackhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class WorkstationActivity extends AppCompatActivity {

    private int clusterSelected;
    private int wingSelected;
    private int floorSelected;
    private Spinner spnClusters;
    private Spinner spnWings;
    private Spinner spnFloors;
    private Button btnFindWs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workstation);

        spnClusters = (Spinner) findViewById(R.id.sp_cluster_spinner);
        String[] clusters = {"Choose a cluster","Cluster B", "Cluster E"};
        ArrayAdapter<String> adapter_cluster = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, clusters);
        spnClusters.setAdapter(adapter_cluster);
//        spnClusters.setPrompt("Choose a cluster");

        spnClusters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        // Whatever you want to happen when the first item gets selected
                        clusterSelected=0;
                        break;
                    case 1:
                        // Whatever you want to happen when the second item gets selected
                        clusterSelected=1;
                        break;
                    case 2:
                        clusterSelected=2;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        spnWings = (Spinner) findViewById(R.id.sp_wing_spinner);
        String[] wings = {"Choose a wing","Wing 1", "Wing 2"};
        ArrayAdapter<String> adapter_wing = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, wings);
        spnWings.setAdapter(adapter_wing);

        spnWings.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        // Whatever you want to happen when the first item gets selected
                        wingSelected=0;
                        break;
                    case 1:
                        // Whatever you want to happen when the second item gets selected
                        wingSelected=1;
                        break;
                    case 2:
                        wingSelected=2;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        spnFloors = (Spinner) findViewById(R.id.sp_floor_spinner);
        String[] floors = {"Choose a floor","Floor 1", "Floor 2"};
        ArrayAdapter<String> adapter_floor = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, floors);
        spnFloors.setAdapter(adapter_floor);

        spnFloors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        // Whatever you want to happen when the first item gets selected
                        floorSelected=0;
                        break;
                    case 1:
                        // Whatever you want to happen when the second item gets selected
                        floorSelected=1;
                        break;
                    case 2:
                        floorSelected=2;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnFindWs = (Button)findViewById(R.id.btn_find_rooms);

        btnFindWs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clusterSelected == 0 || wingSelected == 0 || floorSelected == 0){
                    Toast.makeText(getApplicationContext(),"All fields must be selected",Toast.LENGTH_LONG).show();
                }
                else{
                    redirectToListOfRoomsPage();
                }
            }
        });

    }
    private void redirectToListOfRoomsPage(){
        //int[] selections = {clusterSelected,wingSelected,floorSelected};
        //getAvailableRooms(selections) into string array strings;
        String[] listOfRooms={"room1","room2","room3"};
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add(listOfRooms[0]);
        stringArrayList.add(listOfRooms[1]);
        stringArrayList.add(listOfRooms[2]);
        //Toast.makeText(getApplicationContext(),strings[0] , Toast.LENGTH_LONG).show();
        Bundle b = new Bundle();
        b.putStringArrayList("arrList",stringArrayList);
        Intent intent = new Intent(this, LORActivity.class);
        intent.putExtra("ROOMS_ARRAY", stringArrayList);
        startActivity(intent);
    }

}
