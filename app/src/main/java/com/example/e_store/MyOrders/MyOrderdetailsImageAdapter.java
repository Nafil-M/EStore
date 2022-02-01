package com.example.e_store.MyOrders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_store.R;
import com.example.e_store.WomensSection.WomensDetailedAdapter;

public class MyOrderdetailsImageAdapter extends RecyclerView.Adapter<MyOrderdetailsImageAdapter.MyOrderdetailsImageViewHolder>{

    private Context mContext;

    public MyOrderdetailsImageAdapter( Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public MyOrderdetailsImageAdapter.MyOrderdetailsImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_image_recycler, parent, false);

        return new MyOrderdetailsImageAdapter.MyOrderdetailsImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderdetailsImageAdapter.MyOrderdetailsImageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class MyOrderdetailsImageViewHolder extends RecyclerView.ViewHolder {

        public MyOrderdetailsImageViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
