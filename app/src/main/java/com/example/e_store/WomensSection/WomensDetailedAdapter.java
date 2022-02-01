package com.example.e_store.WomensSection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_store.KidsSection.GirlsAdapter;
import com.example.e_store.R;


//common adapter for buy now page

public class WomensDetailedAdapter extends RecyclerView.Adapter<WomensDetailedAdapter.WomensDetailedViewHolder>{

    private Context mContext;

    public WomensDetailedAdapter( Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public WomensDetailedAdapter.WomensDetailedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_image_recycler, parent, false);

        return new WomensDetailedAdapter.WomensDetailedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WomensDetailedAdapter.WomensDetailedViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class WomensDetailedViewHolder extends RecyclerView.ViewHolder {

        public WomensDetailedViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
