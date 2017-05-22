package com.divyanshgoenka.todolist.models;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.divyanshgoenka.todolist.database.AppDatabase;

import java.util.List;

/**
 * Created by divyanshgoenka on 22/05/17.
 */

public class ToDoItemListViewModel extends AndroidViewModel {
    private AppDatabase mDataBase;
    private LiveData<List<ToDoItem>> toDoItems;
    public ToDoItemListViewModel(Application application) {
        super(application);

    }
}
