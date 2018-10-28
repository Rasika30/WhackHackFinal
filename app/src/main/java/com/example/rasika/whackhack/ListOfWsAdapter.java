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
 * Created by Rasika on 29-10-2018.
 */

public class ListOfWsAdapter extends RecyclerView.Adapter<ListOfWsAdapter.ViewHolder> {
    private static ListOfWsAdapter.WsClickListener wsClickListener;
    private ArrayList<String> wsList;
    private Context holderContext;

    public ListOfWsAdapter(ArrayList<String> ws, Context context) {
        wsList = ws;
        Log.d("Adapter", ws.get(1));
        holderContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_ws, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvWsName.setText(wsList.get(position));
    }


    @Override
    public int getItemCount() {
        return wsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvWsName;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            tvWsName = (TextView)view.findViewById(R.id.tv_ws_name);
        }

        @Override
        public void onClick(View view) {
            wsClickListener.onItemClick(getAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(WsClickListener wsClickListener) {
        ListOfWsAdapter.wsClickListener = wsClickListener;
    }

    public interface WsClickListener {
        void onItemClick(int position, View view);
    }


}
