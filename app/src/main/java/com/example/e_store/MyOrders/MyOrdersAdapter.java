package com.example.e_store.MyOrders;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_store.MensSection.MensAdapter;
import com.example.e_store.R;
import com.example.e_store.WomensSection.WomensDetailedActivity;

public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.MyOrdersViewHolder>{

    private Context mContext;

    public MyOrdersAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public MyOrdersAdapter.MyOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_myorders, parent, false);

        return new MyOrdersAdapter.MyOrdersViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrdersAdapter.MyOrdersViewHolder holder, int position) {

        holder.orderId.setText(String.valueOf(position+1));

        holder.mainltt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MyOrderDetailsActivity.class);
                //pass id(api) to next activity..then give that id as request in next activity to get the details.
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyOrdersViewHolder extends RecyclerView.ViewHolder {

        TextView orderId,brandName,desc;
        RelativeLayout mainltt;

        public MyOrdersViewHolder(@NonNull View itemView) {
            super(itemView);

            mainltt = itemView.findViewById(R.id.mainltt);
            orderId = itemView.findViewById(R.id.id);
            brandName = itemView.findViewById(R.id.brandd);
            desc = itemView.findViewById(R.id.descr);

        }
    }
}
