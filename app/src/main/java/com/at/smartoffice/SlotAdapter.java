package com.at.smartoffice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SlotAdapter extends RecyclerView.Adapter<SlotAdapter.SlotAdapterViewHolder> {

    private int[] slotList;

    public SlotAdapter( int[] slotList){
        this.slotList = slotList;
    }

    @NonNull
    @Override
    public SlotAdapter.SlotAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView =layoutInflater.inflate(R.layout.slot_item,parent, false);

        SlotAdapterViewHolder slotAdapterViewHolder = new SlotAdapterViewHolder(itemView);


        return slotAdapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SlotAdapter.SlotAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    class SlotAdapterViewHolder extends RecyclerView.ViewHolder {

        public SlotAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


}
