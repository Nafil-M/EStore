package com.example.e_store.Cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_store.KidsSection.BoysAdapter;
import com.example.e_store.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder>{

    private Context mContext;

    public CartAdapter( Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_cart, parent, false);

        return new CartAdapter.CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        RelativeLayout mainlt;
        TextView brandName,descreption;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            mainlt = itemView.findViewById(R.id.main);
            image = itemView.findViewById(R.id.imggg);
            brandName = itemView.findViewById(R.id.brandname);
            descreption = itemView.findViewById(R.id.descreption);
        }
    }
}
