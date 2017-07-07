package com.example.knisya.knisya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Willi on 04/06/2017.
 */

public class CoffeAdapter extends BaseAdapter {

    Context mCtx;

    public CoffeAdapter(Context ctx){
        listCoffe = new ArrayList<>();
        mCtx = ctx;
    }

    private ArrayList<Coffe> listCoffe;

    public void setListCoffe(ArrayList<Coffe> listCoffe) {
        this.listCoffe = listCoffe;
    }

    public ArrayList<Coffe> getListCoffe() {
        return listCoffe;
    }

    @Override
    public int getCount() {
        return listCoffe.size();
    }

    @Override
    public Object getItem(int position) {
        return listCoffe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(mCtx).inflate(R.layout.item_row_baju, parent, false);

        ImageView ivThumbnail = (ImageView) v.findViewById(R.id.ivThumbnail);
        TextView tvCoffeName = (TextView) v.findViewById(R.id.tvCoffeName);
        TextView tvCoffeDesc = (TextView) v.findViewById(R.id.tvCoffeDesc);
        TextView tvHarga = (TextView) v.findViewById(R.id.tvHarga);

        Coffe coffe = listCoffe.get(position);
        ivThumbnail.setImageResource(coffe.image);
        tvCoffeName.setText(coffe.name);
        tvCoffeDesc.setText(coffe.desc);
        tvHarga.setText(coffe.harga);
        return v;
    }
}
