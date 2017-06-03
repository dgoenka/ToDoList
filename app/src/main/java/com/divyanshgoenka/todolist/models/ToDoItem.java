package com.divyanshgoenka.todolist.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.divyanshgoenka.todolist.R;
import com.divyanshgoenka.todolist.adapter.ToDoListAdapter;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by divyanshgoenka on 22/05/17.
 */

@Entity
public class ToDoItem implements Serializable {
    public
    @PrimaryKey
    String id;
    public String title;
    public String detail;
    public int status;
    public long created;
    public long due;

    public ToDoItem(String title) {
        this.title = title;
    }

    public ToDoItem(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        List<ToDoItem> toDoItems;

        @BindView(R.id.textView)
        TextView txtView;

        @BindView(R.id.done)
        View done;

        private ToDoListAdapter toDoListAdapter;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        public void onBind(ToDoListAdapter toDoListAdapter, List<ToDoItem> toDoItems, int position) {
            this.toDoItems = toDoItems;
            this.toDoListAdapter = toDoListAdapter;
            ToDoItem toDoItem = toDoItems.get(position);
            txtView.setText(toDoItem.title);
            done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO - Logic to send 'done' message to server
                    ToDoItem.ViewHolder.this.toDoItems.remove(position);
                    ToDoItem.ViewHolder.this.toDoListAdapter.notifyItemRemoved(position);
                    ToDoItem.ViewHolder.this.toDoListAdapter.notifyItemRangeChanged(position, ToDoItem.ViewHolder.this.toDoItems.size());
                }
            });

        }

        public void onUnbind() {
            txtView.setText(null);
            done.setOnClickListener(null);
            toDoItems = null;
            toDoListAdapter = null;
        }
    }
}
