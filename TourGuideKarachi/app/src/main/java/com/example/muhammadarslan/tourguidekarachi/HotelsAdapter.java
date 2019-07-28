package com.example.muhammadarslan.tourguidekarachi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muhammad Arslan on 9/14/2017.
 */

public class HotelsAdapter extends RecyclerView.Adapter<HotelsAdapter.HotelsViewHolder> {


    ArrayList<Hotels> hotelsArrayList=new ArrayList<Hotels>();

    public HotelsAdapter(ArrayList<Hotels> hotelsArrayList) {
        this.hotelsArrayList = hotelsArrayList;
    }

    @Override
    public HotelsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_hotel,parent,false);
        HotelsViewHolder hotelsViewHolder=new HotelsViewHolder(view);
        return hotelsViewHolder;
    }

    @Override
    public void onBindViewHolder(HotelsViewHolder holder, int position) {
        Hotels HOTELS=hotelsArrayList.get(position);
        holder.hotelImage.setImageResource(HOTELS.getmImage_id());
        holder.title.setText(HOTELS.getmTitle());
        holder.description.setText(HOTELS.getmDescription());
        holder.contact.setText(HOTELS.getmContact());
        holder.location.setText(HOTELS.getmLocation());

    }

    @Override
    public int getItemCount() {
        return hotelsArrayList.size();
    }

    public static class HotelsViewHolder extends RecyclerView.ViewHolder{
        ImageView hotelImage;
        TextView title, description, contact,location;
        public HotelsViewHolder(View view){
            super(view);
            hotelImage=(ImageView)view.findViewById(R.id.hotel_image);
            title=(TextView)view.findViewById(R.id.title_text);
            description=(TextView)view.findViewById(R.id.description);
            contact=(TextView)view.findViewById(R.id.contact);
            location=(TextView)view.findViewById(R.id.location);
        }
    }
}


