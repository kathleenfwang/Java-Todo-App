package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
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

        // create the new items adapter
        ItemAdapter itemAdapter = new ItemAdapter(items);
        // set item adapter to recycler view
        rvItems.setAdapter(itemAdapter);
        // set new layout manager for recycler view (default is vertical for linear)
        rvItems.setLayoutManager(new LinearLayoutManager(this));

        btnAdd = findViewById(R.id.btnAdd);
        editText = findViewById(R.id.editText);
        rvItems = findViewById(R.id.rvItems);
        editText.setText("Edited from java");
    }
}