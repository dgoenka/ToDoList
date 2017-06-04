package com.divyanshgoenka.todolist.models;

import android.util.Log;

import com.divyanshgoenka.todolist.ToDoListApplication;

import java.util.List;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;


/**
 * Created by divyanshgoenka on 04/06/17.
 */

public class ToDoItemsProvider implements ObservableOnSubscribe<List<ToDoItem>> {

    private static final String TAG = "ToDoItemsProvider";

    @Override
    public void subscribe(final ObservableEmitter e) throws Exception {
        List<ToDoItem> list = ToDoListApplication.getInstance().getAppDatabase().toDoItemDao().getAllEvents();
        if (!e.isDisposed())
            e.onNext(list);
        Log.e(TAG, " the list is " + list);
    }
}
