package com.example.todo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{


    public interface onLongClickListener {
        void onItemLongClicked(int position);
    }
    List<String> items;
    onLongClickListener onLongClickListener;
    Context context;
    // generate constcutor to allow arguments be passed in
    public ItemAdapter(List<String> items, onLongClickListener onLongClickListener, Context context) {
        this.context = context;
        this.items = items;
        this.onLongClickListener = onLongClickListener;
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
            // set  long click listener for each item to hold remove functinonality
            tvItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // change color
                    tvItem.setTextColor(Color.parseColor("#bdbdbd"));
                }
            });
            tvItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    // on long click, remove the item
                    onLongClickListener.onItemLongClicked(getAdapterPosition());
                    Toast.makeText(context, "Deleted " + tvItem.getText(), Toast.LENGTH_SHORT).show();
                    // consuming the long click
                    return true;
                }
            });
        }
    }

}
