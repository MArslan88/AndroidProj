package com.example.muhammadarslan.checkboxinlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Muhammad Arslan on 11/14/2017.
 */

public class CustomAdapter extends ArrayAdapter {
    Model[] modelItems = null;
    Context context;
    EditText edtText;
    TextView name;
    CheckBox cb;

    public CustomAdapter(Context context, Model[] resource) {
        super(context,R.layout.row,resource);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.modelItems = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row, parent, false);
        edtText = (EditText)convertView.findViewById(R.id.edtText);
        name = (TextView) convertView.findViewById(R.id.textView1);
        cb = (CheckBox) convertView.findViewById(R.id.checkBox1);

        name.setText(modelItems[position].getName());
        if(modelItems[position].getValue() == 1)
            cb.setChecked(true);
        else
            cb.setChecked(false);
        return convertView;
    }

}
