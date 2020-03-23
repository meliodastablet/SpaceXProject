package com.mcakiroglu.spacexproject.adapters;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mcakiroglu.spacexproject.R;
import com.mcakiroglu.spacexproject.activities.LaunchDetailsActivity;
import com.mcakiroglu.spacexproject.classes.Launches;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.containsIgnoreCase;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> implements View.OnClickListener{

    Context context;
    List<Launches> data;
    TextView tw,tw2;

    public RecyclerViewAdapter(Context context, List<Launches> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recyclerview_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //BIND DATA
        final Launches launches = data.get(position);
        holder.tvName.setText(launches.getMissionName());
        holder.tvName2.setText(launches.launchYear);

        holder.tvName.setOnClickListener((View.OnClickListener) RecyclerViewAdapter.this);
        holder.tvName2.setOnClickListener((View.OnClickListener) RecyclerViewAdapter.this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v){

        tw = v.findViewById(R.id.textView);
        tw2 = v.findViewById(R.id.textView2);
        if(v.getId() == R.id.textView || v.getId() == R.id.textView2){
            for(int i=0; i<data.size();i++){
                if(containsIgnoreCase(data.get(i).missionName,tw.getText().toString())) {
                    Intent intent = new Intent(context, LaunchDetailsActivity.class);
                    intent.putExtra("flightnum",data.get(i).flightNumber +  "");
                    context.startActivity(intent);
                }

            }

        }

    }

    class MyViewHolder extends RecyclerView.ViewHolder{


        TextView tvName,tvName2;


        MyViewHolder(View viewItem){
            super(viewItem);
            tvName = viewItem.findViewById(R.id.textView);
            tvName2 = viewItem.findViewById(R.id.textView2);
        }
    }



}