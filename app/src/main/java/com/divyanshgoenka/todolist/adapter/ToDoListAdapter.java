package com.divyanshgoenka.todolist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.divyanshgoenka.todolist.R;
import com.divyanshgoenka.todolist.models.ToDoItem;
import com.divyanshgoenka.todolist.util.Validations;

import java.util.List;

/**
 * Created by divyanshgoenka on 03/06/17.
 */

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoItem.ViewHolder> {

    private List<ToDoItem> items;
    private LayoutInflater layoutInflater;

    public ToDoListAdapter(Context context, List<ToDoItem> items) {
        layoutInflater = LayoutInflater.from(context);
        this.items = items;
    }

    @Override
    public ToDoItem.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ToDoItem.ViewHolder(layoutInflater.inflate(R.layout.to_do_item, parent, false));
    }

    @Override
    public void onViewRecycled(ToDoItem.ViewHolder holder) {
        super.onViewRecycled(holder);
        holder.onUnbind();
    }

    @Override
    public void onBindViewHolder(ToDoItem.ViewHolder holder, int position) {
        holder.onBind(items, position);
    }

    @Override
    public int getItemCount() {
        return Validations.isEmptyOrNull(items) ? 0 : items.size();
    }
}
