package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText nameEditText;
    EditText ageEditText;
    Button save_button;
    databasehelper db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nameEditText = findViewById(R.id.name_editText);
        ageEditText = findViewById(R.id.age_as_number);

        save_button = findViewById(R.id.save_button);
        db = new databasehelper(getApplicationContext());
        AddData();
    }

    public void AddData() {
        save_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("name", nameEditText.getText().toString());
                Log.i("age", ageEditText.getText().toString());

                if (nameEditText.getText().toString().equals("") || ageEditText.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Data insertion unsuccessful", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean isInserted = db.InsertData(nameEditText.getText().toString(), ageEditText.getText().toString());
                    if (isInserted)
                        Toast.makeText(getApplicationContext(), "Your data has been saved successfully", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "Data insertion unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
