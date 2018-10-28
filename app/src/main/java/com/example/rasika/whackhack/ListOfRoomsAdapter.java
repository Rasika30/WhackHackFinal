package com.example.rasika.whackhack;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rasika on 28-10-2018.
 */

public class ListOfRoomsAdapter extends RecyclerView.Adapter<ListOfRoomsAdapter.ViewHolder> {

    private static RoomClickListener roomClickListener;
    private ArrayList<String> roomList;
    private Context holderContext;

    public ListOfRoomsAdapter(ArrayList<String> rooms, Context context) {
        roomList = rooms;
        Log.d("Adapter", rooms.get(1));
        holderContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_room, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvRoomName.setText(roomList.get(position));
    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvRoomName;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            tvRoomName = (TextView)view.findViewById(R.id.tv_room_name);
        }

        @Override
        public void onClick(View view) {
            roomClickListener.onItemClick(getAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(RoomClickListener roomClickListener) {
        ListOfRoomsAdapter.roomClickListener = roomClickListener;
    }

    public interface RoomClickListener {
        void onItemClick(int position, View view);
    }
}
