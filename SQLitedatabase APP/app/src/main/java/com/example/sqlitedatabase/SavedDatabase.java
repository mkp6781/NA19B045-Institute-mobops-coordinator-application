package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.CursorAdapter;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class SavedDatabase extends AppCompatActivity {
    TextView textView;
    ListView listView;
    databasehelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_database);
        textView = findViewById(R.id.no_record_textView);
        listView = findViewById(R.id.listview);

        db = new databasehelper(getApplicationContext());
        Cursor res = db.getData();
        int num = res.getCount();

        if(res.getCount()==0){
            textView.setVisibility(View.VISIBLE);
        }
        else{
            listView.setVisibility(View.VISIBLE);
            String[] from = {res.getColumnName(0).toString() , res.getColumnName(1).toString(), res.getColumnName(2).toString()};
            int[] to = new int[] {R.id.id_test_view , R.id.name_text_view , R.id.age_text_view };
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.row_final, res, from, to, 0);
            listView.setAdapter(adapter);
        }
    }
}
