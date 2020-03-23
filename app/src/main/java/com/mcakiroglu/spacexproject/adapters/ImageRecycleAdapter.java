package com.mcakiroglu.spacexproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mcakiroglu.spacexproject.R;

import java.util.ArrayList;
import java.util.List;

public class ImageRecycleAdapter extends RecyclerView.Adapter<ImageRecycleAdapter.MyViewHolder>{

    Context context;
    ArrayList<String> data;

    public ImageRecycleAdapter(Context context, ArrayList<String> data){

        this.context = context;
        this.data = data;

    }

    @Override
    public ImageRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.imagerecycle_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //BIND DATA
        final String list = data.get(position);
        Glide.with(context).load(list).into(holder.tvName);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView tvName;


        MyViewHolder(View viewItem) {
            super(viewItem);
            tvName = viewItem.findViewById(R.id.iww);

        }
    }

}
