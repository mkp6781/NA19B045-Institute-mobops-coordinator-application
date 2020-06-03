package com.example.manup.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Grocery_list extends AppCompatActivity {
    ListView listView;
    ArrayList<String> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);

        ListView listView = (ListView) findViewById(R.id.list);
        final ArrayList<String> myList = new ArrayList<String>();
        myList.add("TOOTHBRUSH");
        myList.add("TOOTHPASTE");
        myList.add("SOAP");
        myList.add("PEN");
        myList.add("PENCIL");
        myList.add("ERASER");
        myList.add("CARPET");
        myList.add("TIFFIN BOX");
        myList.add("BOTTLE");
        myList.add("PLATE");
        myList.add("SPOON");
        myList.add("KNIFE");
        myList.add("FORK");
        myList.add("HANDWASH");
        myList.add("BISCUIT");

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext() , android.R.layout.simple_list_item_1 , myList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext() , myList.get(position).toString() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
