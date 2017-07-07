package com.example.knisya.knisya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.knisya.knisya.CoffeAdapter;
import com.example.knisya.knisya.MainActivity;

import org.w3c.dom.Text;


public class Desc extends AppCompatActivity  {
    TextView tvCoffeName;
    TextView tvDesc;
    TextView tvHarga;
    RadioButton rbThree;
    RadioButton rbTwo;
    RadioButton rbOne;
    ImageView ivThumbnail;
    Button btnBuy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc2);

        tvCoffeName = (TextView) findViewById(R.id.tvCoffeName);
        tvHarga = (TextView) findViewById(R.id.tvHarga);
        ivThumbnail = (ImageView) findViewById(R.id.ivThumbnail);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String titlle = bundle.getString("title");
        String image = bundle.getString("image");
        String harga = bundle.getString("harga");
        tvCoffeName.setText("title");
        tvHarga.setText("harga");
        ivThumbnail.setImageResource(R.drawable.muslim1);

    }
}
