package com.example.e_store.MensSection;

import android.content.Context;
import android.content.Intent;
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
import com.example.e_store.WomensSection.WomensDetailedActivity;

public class MensAdapter extends RecyclerView.Adapter<MensAdapter.MensViewHolder>{

    private Context mContext;

    public MensAdapter( Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public MensAdapter.MensViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_boys, parent, false);

        return new MensAdapter.MensViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MensAdapter.MensViewHolder holder, int position) {

        holder.mainlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WomensDetailedActivity.class);
                //pass id(api) to next activity..then give that id as request in next activity to get the details.
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MensViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        RelativeLayout mainlt;
        TextView brandName,descreption;

        public MensViewHolder(@NonNull View itemView) {
            super(itemView);

            mainlt = itemView.findViewById(R.id.main);
            image = itemView.findViewById(R.id.imggg);
            brandName = itemView.findViewById(R.id.brandname);
            descreption = itemView.findViewById(R.id.descreption);
        }
    }
}
