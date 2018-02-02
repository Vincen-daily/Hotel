package com.example.hotelapp.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hotelapp.R;
import com.example.hotelapp.model.CityData;

import java.util.List;

/**
 * Created by xiecy on 2018/01/17.
 */

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder>{

    private OnItemClickListener listener;
    private List<CityData.DataBean> data;
    private Context context;

    public HotelAdapter(List<CityData.DataBean> data, Context context,OnItemClickListener listener) {
        this.listener = listener;
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.click(data.get(position),listener);
        holder.city.setText(data.get(position).getName());
        holder.hotel.setText(data.get(position).getDescription());
        String pic=data.get(position).getBackground();
        Glide.with(context).load(pic).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public interface OnItemClickListener{
            void onClick(CityData.DataBean dataBean);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView city,hotel;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            city=itemView.findViewById(R.id.city);
            hotel=itemView.findViewById(R.id.hotel);
            image=itemView.findViewById(R.id.image);
        }

        public void click(final CityData.DataBean dataBean, final OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(dataBean);
                }
            });
        }
    }
}
