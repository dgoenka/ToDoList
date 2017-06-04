package com.divyanshgoenka.todolist.models;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by divyansh goenka on 22/05/17.
 */

@Dao
public interface ToDoItemDao {
    @Insert
    public void addEvent(ToDoItem toDoItem);

    @Query("Select * from TODOITEM")
    public List<ToDoItem> getAllEvents();

    @Update
    public void updateEvent(ToDoItem toDoItem);

    @Query("delete from TODOITEM where id = :id")
    public void delete(long id);

    @Query("delete from TODOITEM")
    public void deleteAll();

}
