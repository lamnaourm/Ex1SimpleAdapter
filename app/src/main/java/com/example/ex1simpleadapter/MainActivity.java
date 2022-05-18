package com.example.ex1simpleadapter;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pays> list_pays = new ArrayList<>();
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_pays.add(new Pays("Argentine", "Buenos aeres", "Amerique", 766786, R.drawable.ar));
        list_pays.add(new Pays("Maroc", "Rabat", "Afrique", 215454, R.drawable.ma));
        list_pays.add(new Pays("Bresil", "Rio", "Amerique", 23434, R.drawable.br));
        list_pays.add(new Pays("Alemagne", "Berlin", "Europe", 909090, R.drawable.de));
        list_pays.add(new Pays("Espagne", "Madrid", "Europe", 21212, R.drawable.es));

        lst = findViewById(R.id.lst);
        ArrayList<HashMap<String, Object>> list_items = new ArrayList<>();
        for (Pays p : list_pays) {
            HashMap<String, Object> it = new HashMap<>();
            it.put("imageP", p.getImage());
            it.put("nomP", p.getNom());
            it.put("popP", p.getPopulation());
            list_items.add(it);
        }
        String[] from = {"imageP", "nomP","popP"};
        int[] to = {R.id.imagePays, R.id.paysNom,R.id.paysPopulation};

        SimpleAdapter ad = new SimpleAdapter(this, list_items, R.layout.item_pays, from, to);
        lst.setAdapter(ad);
    }
}