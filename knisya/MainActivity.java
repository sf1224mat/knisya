package com.example.knisya.knisya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvCoffe;
    CoffeAdapter adapter;
    ArrayList<Coffe> listCoffe;
    Button btnshop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Button btnShop = (Button) findViewById(R.id.btnShop);

        lvCoffe = (ListView) findViewById(R.id.lvCoffe);
        adapter = new CoffeAdapter(this);
        //initialize listCoffe

        listCoffe = new ArrayList<>();
        final Coffe coffe1 = new Coffe();
        Coffe coffe2 = new Coffe();
        Coffe coffe3 = new Coffe();
        Coffe coffe4 = new  Coffe();
        Coffe coffe5 = new  Coffe();
        Coffe coffe6 = new  Coffe();

        coffe1.image = R.drawable.muslim1;
        coffe2.image = R.drawable.muslim2;
        coffe3.image = R.drawable.muslim3;
        coffe4.image = R.drawable.muslim4;
        coffe5.image = R.drawable.muslim5;
        coffe6.image = R.drawable.muslim6;

        coffe1.name = "Muslim Wanita Terkini";
        coffe2.name = "Muslim Wanita Modern";
        coffe3.name = "Muslim Wanita Terkini";
        coffe4.name = "Muslim Wanita Terkini";
        coffe5.name = "Muslim Wanita Modern";
        coffe6.name = "Muslim Wanita Modern";

        coffe1.desc = "Baju muslim ini terbuat dari bahan yang berkualitas tentunya halus dan nyaman untuk dipakai";
        coffe2.desc = "Baju muslim ini bisa dipakai untuk kerja";
        coffe3.desc = "Baju muslim ini bahannya nyaman untuk dipakai dan tidak gerah";
        coffe4.desc = "kopi terindah yang pernah kuminum pagi ini";
        coffe5.desc = "kopi terindah yang pernah kuminum pagi ini";
        coffe6.desc = "Baju muslim ini salah satu trend di tahun 2017 dari warna dan bahannya yg bagus"; // Taro di database

        coffe1.harga = "Rp. 259.000";  // Taro Didatabase
        coffe2.harga = "Rp. 350.000";
        coffe3.harga = "Rp. 240.000";
        coffe4.harga = "Rp. 260.000";
        coffe5.harga = "Rp. 400.000";
        coffe6.harga = "Rp. 390.000";

        listCoffe.add(coffe1);
        listCoffe.add(coffe2);
        listCoffe.add(coffe3);
        listCoffe.add(coffe4);
        listCoffe.add(coffe5);
        listCoffe.add(coffe6);



        adapter.setListCoffe(listCoffe);
        lvCoffe.setAdapter(adapter);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, R.id.lvCoffe);

        lvCoffe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent desc = new Intent(MainActivity.this, Desc.class);
                        desc.putExtra("title", coffe1.name);
                        desc.putExtra("image", coffe1.image);
                        desc.putExtra("desc", coffe1.desc);
                        desc.putExtra("harga", coffe1.harga);

                        startActivity(desc);
                        break;
                    default:
                        break;
                }
            }
        });

    }
}





