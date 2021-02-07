package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> items;
    Button btnAdd;
    EditText editText;
    RecyclerView rvItems;
    ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        items.add("Wash dishes");
        items.add("Finish homework");
        items.add("Play piano");

        // set the variables to equal their View Ids
        btnAdd = findViewById(R.id.btnAdd);
        editText = findViewById(R.id.editText);
        rvItems = findViewById(R.id.rvItems);

        // set LongOnClick
        ItemAdapter.onLongClickListener onLongClickListener = new ItemAdapter.onLongClickListener() {
            @Override
            public void onItemLongClicked(int position) {
                // remove the item at position from items array
                items.remove(position);
                // notify the adapter
                itemAdapter.notifyItemRemoved(position);
            }
        };
        // create the new items adapter
        itemAdapter = new ItemAdapter(items, onLongClickListener, this);
        // set item adapter to recycler view
        rvItems.setAdapter(itemAdapter);
        // set new layout manager for recycler view (default is vertical for linear)
        rvItems.setLayoutManager(new LinearLayoutManager(this));

        // set onclick listener for add button
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // onClick activity happens in here
                // get the text from the editText view and turn into string
                String todoItem = editText.getText().toString();
                // add item to model
                items.add(todoItem );
                // notify adapter an item is added
                itemAdapter.notifyItemInserted(items.size() -1);
                // clear editText
                editText.setText("");
            }
        });
    }
    // return file from storage
    private File getDataFile() {
        // return file directory this app is stored
        return new File(getFilesDir(),"data.txt");
    }
}