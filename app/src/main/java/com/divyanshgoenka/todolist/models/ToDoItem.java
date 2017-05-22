package com.divyanshgoenka.todolist.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by divyanshgoenka on 22/05/17.
 */

@Entity
public class ToDoItem {
    public @PrimaryKey String id;
    public String title;
    public String detail;
    public int status;
    public long created;
    public long due;
}
