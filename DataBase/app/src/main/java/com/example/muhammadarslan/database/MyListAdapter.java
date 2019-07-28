package com.example.muhammadarslan.database;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Muhammad Arslan on 9/24/2017.
 */

public class MyListAdapter extends ArrayAdapter<Name> {

    ArrayList<Name> names;
    MySqliteHelper mySqliteHelper;

    public MyListAdapter(@NonNull Context context, ArrayList<Name> names, MySqliteHelper mySqliteHelper) {
        super(context, 0, names);
        this.names = names;
        this.mySqliteHelper = mySqliteHelper;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout,parent,false);
        }

        TextView tvName=(TextView)convertView.findViewById(R.id.tvName);
        Button btnDel=(Button) convertView.findViewById(R.id.btnDel);

        final Name name=names.get(position);
        tvName.setText(name.getName());

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mySqliteHelper.delContact(name.getId());
                names.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;

    }
}
