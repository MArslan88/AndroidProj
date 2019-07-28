package com.example.muhammadarslan.cardviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muhammad Arslan on 9/7/2017.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    ArrayList<Contact> contacts=new ArrayList<Contact>();

    public ContactAdapter(ArrayList<Contact> contacts){
        this.contacts=contacts;
    }
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout,parent,false);
        ContactViewHolder contactViewHolder=new ContactViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Contact CONTACT=contacts.get(position);
        holder.hotelImage.setImageResource(CONTACT.getmImage_id());
        holder.title.setText(CONTACT.getmTitle());
        holder.description.setText(CONTACT.getmDescription());
        holder.contact.setText(CONTACT.getmContact());
        holder.location.setText(CONTACT.getmLocation());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{
        ImageView hotelImage;
        TextView title, description, contact,location;
        public ContactViewHolder(View view){
            super(view);
            hotelImage=(ImageView)view.findViewById(R.id.hotel_image);
            title=(TextView)view.findViewById(R.id.title_text);
            description=(TextView)view.findViewById(R.id.description);
            contact=(TextView)view.findViewById(R.id.contact);
            location=(TextView)view.findViewById(R.id.location);
        }
    }
}
