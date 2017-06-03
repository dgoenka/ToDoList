package com.divyanshgoenka.todolist.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.divyanshgoenka.todolist.models.ToDoItem;
import com.divyanshgoenka.todolist.models.ToDoItemDao;

/**
 * Created by divyanshgoenka on 22/05/17.
 */
@Database(entities = {ToDoItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ToDoItemDao toDoItemDao();
}
