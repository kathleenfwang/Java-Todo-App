package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> items;
    Button btnAdd;
    EditText editText;
    RecyclerView rvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        items.add("Wash dishes");
        items.add("Finish homework");
        items.add("Play piano");

        btnAdd = findViewById(R.id.btnAdd);
        editText = findViewById(R.id.editText);
        rvItems = findViewById(R.id.rvItems);
        editText.setText("Edited from java");
    }
}