package com.divyanshgoenka.todolist.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import com.divyanshgoenka.todolist.models.ToDoItem;

/**
 * Created by divyanshgoenka on 22/05/17.
 */
@Database(entities = {ToDoItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
}
