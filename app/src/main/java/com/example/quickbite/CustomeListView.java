package com.example.quickbite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomeListView extends BaseAdapter {
    Context context;
    String names[];
    int images[];
    String price[];
    LayoutInflater inflater;

    public CustomeListView(Context ctx,String[] nm ,int[] img, String[] amount){
        this.context = ctx;
        this.images = img;
        this.names = nm;
        this.price = amount;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_list_item,null);
        TextView txtview = (TextView) convertView.findViewById(R.id.name);
        ImageView img = (ImageView) convertView.findViewById(R.id.image);
        TextView pricetxt = (TextView) convertView.findViewById(R.id.price);
        txtview.setText(names[position]);
        pricetxt.setText("₹ "+price[position]);
        img.setImageResource(images[position]);
        return convertView;
    }
}