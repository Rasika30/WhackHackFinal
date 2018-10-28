package com.example.rasika.whackhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class LOWActivity extends AppCompatActivity {

    RecyclerView rvListOfWs;
    private ListOfWsAdapter listOfWsAdapter;

    ArrayList<String> strings = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        strings = this.getIntent().getStringArrayListExtra("WS_ARRAY");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low);

        rvListOfWs = (RecyclerView) findViewById(R.id.rv_ws_list);
        rvListOfWs.setHasFixedSize(true);
        Log.d("LOWAct", "Size: " + strings.size());
        listOfWsAdapter = new ListOfWsAdapter(strings, getBaseContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        rvListOfWs.setLayoutManager(layoutManager);
        listOfWsAdapter.setOnItemClickListener(new ListOfWsAdapter.WsClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(getBaseContext(), strings.get(position) + "selected", Toast.LENGTH_LONG).show();
            }
        });
        rvListOfWs.setAdapter(listOfWsAdapter);
        rvListOfWs.addItemDecoration(new DividerItemDecoration(getBaseContext(), DividerItemDecoration.VERTICAL));

    }
}
