package com.example.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    List<String> items;
    // generate constcutor to allow arguments be passed in
    public ItemAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    // create a new ViewHolder and inflate from parent and then return it
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // use layout inflator to inflate a view
        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
        return new ViewHolder(todoView);
    }
    // bind each data to a viewholder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    // grab the item at the position
        String item = items.get(position);
        //bind the data
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        // get number of items
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        // declare the TextView we will be modifying (setting text for)
        TextView tvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // set tvItem using the passed in itemView 
            tvItem = itemView.findViewById(android.R.id.text1);
        }

        // update the view inside the viewholder with this item data
        public void bind(String item) {
            // us the binded item in our textview
            tvItem.setText(item);
        }
    }

}
